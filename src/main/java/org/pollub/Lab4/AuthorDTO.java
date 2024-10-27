package org.pollub.Lab4;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthorDTO {
    private String name;
    private String surname;
    private String email;

    public AuthorDTO(Author author) {
        this.name = author.getName();
        this.surname = author.getSurname();
        this.email = author.getEmail();
    }

    public Author toEntity() {
        return new Author(this.name, this.surname, this.email);
    }
}
