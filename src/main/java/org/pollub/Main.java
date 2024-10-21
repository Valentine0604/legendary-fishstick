package org.pollub;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Author> authors = List.of(
                new Author(1L, "J.D", "Salinger"),
                new Author(2L, "J.K", "Rowling"),
                new Author(3L, "A. A.", "Milne")
        );

        XMLUtil.saveXMLToFile(new Authors(authors), "authors.xml");

        System.out.println("Authors info from XML file:");
        XMLUtil.readXMLFromFile("authors.xml");
    }
}
