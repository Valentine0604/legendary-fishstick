package org.pollub.Lab4.DTO;

import lombok.Getter;
import lombok.ToString;
import org.pollub.Lab4.Entity.Library;

import java.util.List;

@Getter
@ToString
public class LibraryDTO {
    private final long id;
    private final String name;
    private final String address;
    private final List<EmployeeDTO> employees;

    public LibraryDTO(Library library) {
        this.id = library.getId();
        this.name = library.getName();
        this.address = library.getAddress();
        this.employees = library.getEmployees().stream().map(EmployeeDTO::new).toList();
    }

    public Library toEntity() {
        return new Library(id, name, address, employees.stream().map(EmployeeDTO::toEntity).toList());
    }

}
