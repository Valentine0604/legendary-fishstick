package org.pollub.Lab4;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Book {
    private String title;
    private final String author;
    private int year;
    private String publisher;

}
