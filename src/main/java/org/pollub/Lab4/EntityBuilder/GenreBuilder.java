package org.pollub.Lab4.EntityBuilder;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class GenreBuilder {
    private String name;
    private String description;
}
