package org.pollub.Lab4.DTO;

import lombok.*;
import org.pollub.Lab4.Entity.Reader;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReaderDTO {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;

    public ReaderDTO(Reader reader) {
        this.username = reader.getUsername();
        this.password = reader.getPassword();
        this.name = reader.getName();
        this.surname = reader.getSurname();
        this.email = reader.getEmail();
    }

    public Reader toEntity() {
        return new Reader(this.username, this.password, this.name, this.surname, this.email);
    }
}
