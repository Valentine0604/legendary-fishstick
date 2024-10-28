package org.pollub.Lab4.Entity;


import lombok.*;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@ToString
public class Library {

    private final long id;
    private String name;
    private String address;
    private List<Employee> employees;
}
