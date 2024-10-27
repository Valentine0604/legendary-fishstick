package org.pollub.Lab4.Entity;

import lombok.*;

@Data
@AllArgsConstructor
public class Genre {

    private final long id;
    private String name;
    private String description;

}
