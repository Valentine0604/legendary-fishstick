package org.pollub.Lab4;

import org.pollub.Lab4.DTO.AuthorDTO;
import org.pollub.Lab4.DTO.BookDTO;
import org.pollub.Lab4.DTO.EmployeeDTO;
import org.pollub.Lab4.DTO.GenreDTO;
import org.pollub.Lab4.DTO.LibraryDTO;
import org.pollub.Lab4.DTO.ReaderDTO;
import org.pollub.Lab4.Entity.Author;
import org.pollub.Lab4.Entity.Book;
import org.pollub.Lab4.Entity.Employee;
import org.pollub.Lab4.Entity.Genre;
import org.pollub.Lab4.Entity.Library;
import org.pollub.Lab4.Entity.Reader;
import org.pollub.Lab4.EntityBuilder.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AuthorBuilder authorBuilder = AuthorBuilder.builder().name("J.D").surname("Salinger").email("jd@mail.com").build();
        BookBuilder bookBuilder = BookBuilder.builder().title("The Catcher in the Rye").author("J.D. Salinger").year(1951).publisher("Little, Brown and Company").build();
        ReaderBuilder readerBuilder = ReaderBuilder.builder().name("Valentine").surname("Ewelina").email("Valentine").password("password123").build();
        EmployeeBuilder employeeBuilder = EmployeeBuilder.builder().name("Valentine").email("Valentine").address("Street 1").phone("123456789").build();
        GenreBuilder genreBuilder = GenreBuilder.builder().name("Fiction").description("Books about stories").build();
        LibraryBuilder libraryBuilder = LibraryBuilder.builder().name("Library").address("Street 1").employees(List.of(employeeBuilder)).build();

        System.out.println("***BUILDER CREATION***");
        System.out.println("Author Builder: " + authorBuilder);
        System.out.println("Book Builder: " + bookBuilder);
        System.out.println("Reader Builder: " + readerBuilder);
        System.out.println("Employee Builder: " + employeeBuilder);
        System.out.println("Genre Builder: " + genreBuilder);
        System.out.println("Library Builder: " + libraryBuilder);

        Author authorEntity = new Author(1L, "J.D", "Salinger", "jd@mail.com");
        Book bookEntity = new Book(1L, "The Catcher in the Rye", "J.D. Salinger", 1951, "Little, Brown and Company");
        Reader readerEntity = new Reader(1L, "Valentine", "Ewelina", "Valentine", "ewecia.s@gmail.com", "password123");

        System.out.println("\n***ENTITY CREATION***");
        System.out.println("Author Entity: " + authorEntity);
        System.out.println("Book Entity: " + bookEntity);
        System.out.println("Reader Entity: " + readerEntity);

        AuthorDTO authorDTO = new AuthorDTO(authorEntity);
        BookDTO bookDTO = new BookDTO(bookEntity);
        ReaderDTO readerDTO = new ReaderDTO(readerEntity);

        System.out.println("\n***DTOs CREATED FROM ENTITIES***");
        System.out.println("Author DTO: " + authorDTO);
        System.out.println("Book DTO: " + bookDTO);
        System.out.println("Reader DTO: " + readerDTO);

        Author revertedAuthor = authorDTO.toEntity();
        Book revertedBook = bookDTO.toEntity();
        Reader revertedReader = readerDTO.toEntity();

        System.out.println("\n***ENTITIES REVERTED FROM DTOs***");
        System.out.println("Reverted Author Entity: " + revertedAuthor);
        System.out.println("Reverted Book Entity: " + revertedBook);
        System.out.println("Reverted Reader Entity: " + revertedReader);

        Employee employeeEntity = new Employee(1, "John Doe", "Main Street 12", "123456789", "john@example.com");
        Genre genreEntity = new Genre(1, "Fantasy", "Fantasy books");
        Library libraryEntity = new Library(1, "Library", "Main Street 12", List.of(employeeEntity));

        EmployeeDTO employeeDTO = new EmployeeDTO(employeeEntity);
        GenreDTO genreDTO = new GenreDTO(genreEntity);
        LibraryDTO libraryDTO = new LibraryDTO(libraryEntity);

        System.out.println("\n***ADDITIONAL ENTITY DTOs***");
        System.out.println("Employee DTO: " + employeeDTO);
        System.out.println("Genre DTO: " + genreDTO);
        System.out.println("Library DTO: " + libraryDTO);
    }
}
