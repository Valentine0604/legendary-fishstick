package org.pollub.Lab4.DTO;

import lombok.*;
import org.pollub.Lab4.Entity.Reader;

@Getter

@ToString
public class ReaderDTO {
    private final long id;
    private final String username;
    private final String password;
    private final String name;
    private final String surname;
    private final String email;

    public ReaderDTO(Reader reader) {
        this.id = reader.getId();
        this.username = reader.getUsername();
        this.password = reader.getPassword();
        this.name = reader.getName();
        this.surname = reader.getSurname();
        this.email = reader.getEmail();
    }

    public Reader toEntity() {
        return new Reader(this.id,this.username, this.password, this.name, this.surname, this.email);
    }
}
