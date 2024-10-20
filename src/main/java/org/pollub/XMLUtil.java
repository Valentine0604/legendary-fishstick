package org.pollub;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileWriter;
import java.io.IOException;

public class XMLUtil {

    public static void saveXMLToFile(Object obj, String fileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            FileWriter fileWriter = new FileWriter(fileName);
            jaxbMarshaller.marshal(obj, fileWriter);
            fileWriter.close();
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void readXMLFromFile(String fileName) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(fileName);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            System.out.println("------------------");

            // Pobieranie listy elementów "author"
            NodeList list = doc.getElementsByTagName("author");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Pobieranie atrybutu "authorId"
                    String authorId = element.getAttribute("authorId");

                    // Pobieranie wartości elementów "firstname" i "lastname"
                    String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
                    String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();

                    System.out.println("Author no." + (i + 1) + ":");
                    System.out.println("Author ID: " + authorId);
                    System.out.println("Firstname: " + firstname);
                    System.out.println("Lastname: " + lastname);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
