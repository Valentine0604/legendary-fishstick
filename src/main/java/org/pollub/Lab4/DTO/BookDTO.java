package org.pollub.Lab4.DTO;

import lombok.*;
import org.pollub.Lab4.Entity.Book;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BookDTO {
    private final long id;
    private String title;
    private String author;
    private int year;
    private String publisher;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.year = book.getYear();
        this.publisher = book.getPublisher();
    }

    public Book toEntity() {
        return new Book(this.id, this.title, this.author, this.year, this.publisher);
    }
}
