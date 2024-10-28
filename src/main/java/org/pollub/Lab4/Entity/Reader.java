package org.pollub.Lab4.Entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Reader {
    private final long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
}
