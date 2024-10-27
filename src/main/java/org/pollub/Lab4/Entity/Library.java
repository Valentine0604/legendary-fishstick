package org.pollub.Lab4.Entity;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class Library {

    private final long id;
    private String name;
    private String address;
    private List<Employee> employees;
}
