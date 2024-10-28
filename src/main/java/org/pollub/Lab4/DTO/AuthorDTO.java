package org.pollub.Lab4.DTO;

import lombok.*;
import org.pollub.Lab4.Entity.Author;

@Getter
@ToString
public class AuthorDTO {
    private final long id;
    private final String name;
    private final String surname;
    private final String email;

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.surname = author.getSurname();
        this.email = author.getEmail();
    }

    public Author toEntity() {
        return new Author(this.id, this.name, this.surname, this.email);
    }
}
