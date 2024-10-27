package org.pollub.Lab4;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Author {
    private String name;
    private String surname;
    private final String email;
}
