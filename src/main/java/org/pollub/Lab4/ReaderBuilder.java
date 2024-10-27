package org.pollub.Lab4;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class ReaderBuilder {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
}
