package org.pollub.Lab4.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Book {
    private final long id;
    private String title;
    private final String author;
    private int year;
    private String publisher;

}
