package org.pollub.Lab4.EntityBuilder;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class AuthorBuilder {
    private String name;
    private String surname;
    private String email;
}
