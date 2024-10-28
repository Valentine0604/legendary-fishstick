package org.pollub.Lab4.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@ToString
public class Book {
    private final long id;
    private String title;
    private final String author;
    private int year;
    private String publisher;

}
