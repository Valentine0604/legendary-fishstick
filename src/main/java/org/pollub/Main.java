package org.pollub;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Author a1 = new Author(1L, "J.D", "Salinger");
        XMLUtil.saveXMLToFile(a1, "authors.xml");

        System.out.println("Author info from XML file");
        XMLUtil.readXMLFromFile("authors.xml");
    }
}