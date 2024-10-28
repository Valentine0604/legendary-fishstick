package org.pollub.Lab4.Entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class Genre {

    private final long id;
    private String name;
    private String description;

}
