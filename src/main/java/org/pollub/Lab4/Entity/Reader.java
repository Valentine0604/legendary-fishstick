package org.pollub.Lab4.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Reader {
    private final String username;
    private String password;
    private String name;
    private String surname;
    private String email;
}
