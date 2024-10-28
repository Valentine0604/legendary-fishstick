package org.pollub.Lab4.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.pollub.Lab4.Entity.Genre;

@Getter
@ToString
public class GenreDTO {
    private final long id;
    private final String name;
    private final String description;

    public GenreDTO(Genre genre) {
        this.id = genre.getId();
        this.name = genre.getName();
        this.description = genre.getDescription();
    }

    public Genre toEntity() {
        return new Genre(this.id, this.name, this.description);
    }
}
