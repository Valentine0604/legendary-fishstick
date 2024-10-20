package org.pollub;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlToObject {
    public static void main(String[] args) {
        try {
            Document document = parseXml("books.xml");
            NodeList nodeList = document.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    try {
                        Book book = createBook(element);
                        System.out.println(book);
                    } catch (InvalidDataException e) {
                        System.out.println("Nie można utworzyć obiektu: " + e.getMessage());
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Błąd parsowania XML: " + e.getMessage());
        }
    }

    private static Document parseXml(String fileName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(fileName));
    }

    private static Book createBook(Element element) throws InvalidDataException {
        String id = element.getElementsByTagName("id").item(0).getTextContent();
        String title = element.getElementsByTagName("title").item(0).getTextContent();
        String author = element.getElementsByTagName("author").item(0).getTextContent();

        if (id == null || id.isEmpty() || title == null || title.isEmpty() || author == null || author.isEmpty()) {
            throw new InvalidDataException("Niepoprawne dane");
        }

        return new Book(Long.parseLong(id), title, author);
    }
}

class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}