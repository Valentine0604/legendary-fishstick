//Utwórz 3 klasy encyjne z wykorzystaniem adnotacji Lombok posiadające publiczne metody dostępowe, pola wymagane, konstruktory argumentowe. - 3 p.
//Utwórz 3 klasy wg wzorca Budowniczy z wykorzystaniem biblioteki Lombok i pokaż ich instancje w użyciu. - 4 p.
//Utwórz klika klas DTO, do których mapowane będą dane z instancji klas encyjnych i umożliwiające przywrócenie stanu instancji klasy encyjnej w momencie konieczności wycofania zmian. - 5 p.

package org.pollub.Lab4;

import org.pollub.Lab4.DTO.EmployeeDTO;
import org.pollub.Lab4.DTO.GenreDTO;
import org.pollub.Lab4.DTO.LibraryDTO;
import org.pollub.Lab4.Entity.Employee;
import org.pollub.Lab4.Entity.Genre;
import org.pollub.Lab4.Entity.Library;
import org.pollub.Lab4.EntityBuilder.EmployeeBuilder;
import org.pollub.Lab4.EntityBuilder.GenreBuilder;
import org.pollub.Lab4.EntityBuilder.LibraryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmployeeBuilder employee = EmployeeBuilder.builder()
                .name("John Doe")
                .address("New Street 2")
                .phone("123456789")
                .email("example@example.com")
                .build();

        System.out.println("Employee created with builder: ");
        System.out.println(employee);

        GenreBuilder genre = GenreBuilder.builder()
                .name("Fantasy")
                .description("Fantasy books")
                .build();

        System.out.println("\nGenre created with builder: ");
        System.out.println(genre);

        LibraryBuilder library = LibraryBuilder.builder()
                .name("Library")
                .address("New Street 2")
                .employees(List.of(employee))
                .build();

        System.out.println("\nLibrary created with builder: ");
        System.out.println(library);


        //Zad 2
        System.out.println("\n---------Zad 2---------");
        Employee employee1 = new Employee(1, "Jan Kowalski", "ul. Główna 12", "123456789", "janek@example.com");


        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee1.getId());
        employeeDTO.setName(employee1.getName());
        employeeDTO.setAddress(employee1.getAddress());
        employeeDTO.setPhone(employee1.getPhone());
        employeeDTO.setEmail(employee1.getEmail());

        System.out.println("\nEmployee printed with DTO: ");
        System.out.println(employeeDTO);
        AuthorBuilder author = AuthorBuilder.builder().name("J.D").surname("Salinger").email("jd@mail.com").build();
        BookBuilder book = BookBuilder.builder().author("J.D. Salinger").title("The Catcher in the rye").year(1951).publisher("Little, Brown and Company").build();
        ReaderBuilder reader = ReaderBuilder.builder().username("Valentine").password("Password1234").name("Ewelina").surname("Valentine").email("ewecia.s@gmail.com").build();

        System.out.println(author);
        System.out.println(book);
        System.out.println(reader);
        Genre genre1 = new Genre(1, "Fantasy", "Fantasy books");

        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setName(genre1.getName());
        genreDTO.setDescription(genre1.getDescription());

        System.out.println("\nGenre printed with DTO: ");
        System.out.println(genreDTO);

        Library library1 = new Library(1, "Library", "ul. Główna 12", List.of(employee1));

        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setName(library1.getName());
        libraryDTO.setAddress(library1.getAddress());
        libraryDTO.setEmployees(List.of(employeeDTO));

        System.out.println("\nLibrary printed with DTO: ");
        System.out.println(libraryDTO);

    }
}
