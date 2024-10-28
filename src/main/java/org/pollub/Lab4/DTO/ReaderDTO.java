package org.pollub.Lab4.DTO;

import lombok.*;
import org.pollub.Lab4.Entity.Reader;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ReaderDTO {
    private final long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;

    public ReaderDTO(Reader reader) {
        this.id = reader.getId();
        this.password = reader.getPassword();
        this.name = reader.getName();
        this.surname = reader.getSurname();
        this.email = reader.getEmail();
    }

    public Reader toEntity() {
        return new Reader(this.id,this.username, this.password, this.name, this.surname, this.email);
    }
}
