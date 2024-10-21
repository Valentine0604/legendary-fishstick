package org.pollub;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
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
            Document doc = db.parse(new File(fileName));
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            System.out.println("------------------");

            // Initialize a node list to process the child nodes
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            printNodes(nodeList);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                printNodeDetails(node);
                // Process child nodes if they exist
                if (node.hasChildNodes()) {
                    printNodes(node.getChildNodes());
                }
            }
        }
    }

    private static void printNodeDetails(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            String nodeName = node.getNodeName();

            if (node.hasAttributes()) {
                NamedNodeMap attributes = node.getAttributes();
                for (int j = 0; j < attributes.getLength(); j++) {
                    Node attribute = attributes.item(j);
                    System.out.print(attribute.getNodeName() + ": " + attribute.getNodeValue());
                }
            }

            if (node.hasChildNodes()) {
                NodeList childNodes = node.getChildNodes();
                for (int k = 0; k < childNodes.getLength(); k++) {
                    Node child = childNodes.item(k);
                    if (child.getNodeType() == Node.TEXT_NODE && !child.getNodeValue().trim().isEmpty()) {
                        System.out.print(nodeName + ": " + child.getNodeValue().trim());
                    }
                }
            }
        }
        System.out.println();
    }
}
