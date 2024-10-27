package org.pollub.Lab4.EntityBuilder;

import lombok.Builder;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class LibraryBuilder {
    private String name;
    private String address;
    private List<EmployeeBuilder> employees;
}
