package org.pollub.Lab3;

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

    private static Document parseXml(String fileName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(fileName));
    }

    public interface XmlToObjectConverter<T> {
        T createObject(Element element) throws InvalidDataException;
    }

    public static class BookConverter implements XmlToObjectConverter<Book> {
        @Override
        public Book createObject(Element element) throws InvalidDataException {
            String id = element.getElementsByTagName("id").item(0).getTextContent();
            String title = element.getElementsByTagName("title").item(0).getTextContent();
            String author = element.getElementsByTagName("author").item(0).getTextContent();

            if (id == null || id.isEmpty() || title == null || title.isEmpty() || author == null || author.isEmpty()) {
                throw new InvalidDataException("Wrong data");
            }

            return new Book(Long.parseLong(id), title, author);
        }
    }

    public static class AuthorConverter implements XmlToObjectConverter<Author> {
        @Override
        public Author createObject(Element element) throws InvalidDataException {
            String id = element.getElementsByTagName("id").item(0).getTextContent();
            String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
            String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();

            if (id == null || id.isEmpty() || firstname == null || firstname.isEmpty() || lastname == null || lastname.isEmpty()) {
                throw new InvalidDataException("Wrong data");
            }

            return new Author(Long.parseLong(id), firstname, lastname);
        }
    }

    public static <T> void saveObjectFromXml(XmlToObjectConverter<T> converter, String xmlFile, String tagName) {
        try {
            Document document = parseXml(xmlFile);
            NodeList nodeList = document.getElementsByTagName(tagName);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    try {
                        T object = converter.createObject(element);
                        System.out.println(object);
                    } catch (InvalidDataException e) {
                        System.out.println("Can't create an object: " + e.getMessage());
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Xml parsing error: " + e.getMessage());
        }
    }

    static class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
    }

}