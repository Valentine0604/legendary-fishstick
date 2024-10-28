package org.pollub.Lab4.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Author {
    @Id
    private long id;
    private String name;
    private String surname;
    private final String email;
}
