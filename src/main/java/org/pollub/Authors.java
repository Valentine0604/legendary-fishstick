package org.pollub;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "authors")
public class Authors {

    private List<Author> authors;

    public Authors(){}

    public Authors(List<Author> authors) {
        this.authors = authors;
    }

    @XmlElement(name = "author")
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
