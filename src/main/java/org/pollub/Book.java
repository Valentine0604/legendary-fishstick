package org.pollub;

public class Book {
    private long id;
    private String title;
    private String author;

    public Book(long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }
}
