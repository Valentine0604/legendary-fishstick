package org.pollub.Lab4.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@ToString
public class Author {
    @Id
    private final long id;
    private String name;
    private String surname;
    private String email;
}
