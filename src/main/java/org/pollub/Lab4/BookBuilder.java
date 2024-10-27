package org.pollub.Lab4;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class BookBuilder {
    private String title;
    private String author;
    private int year;
    private String publisher;
}