package org.pollub;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "author")
@XmlAccessorType(XmlAccessType.FIELD)
public class Author {

    @XmlAttribute
    private Long authorId;

    @XmlElement(name = "firstname")
    private String firstname;

    @XmlElement(name = "lastname")
    private String lastname;

    public Author() {
    }

    public Author(Long authorId, String firstname, String lastname) {
        this.authorId = authorId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
