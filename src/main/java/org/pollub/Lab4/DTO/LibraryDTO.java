package org.pollub.Lab4.DTO;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class LibraryDTO {
    private long id;
    private String name;
    private String address;
    private List<EmployeeDTO> employees;
}
