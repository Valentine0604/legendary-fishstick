package org.pollub.Lab4.EntityBuilder;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class EmployeeBuilder {
    private String name;
    private String address;
    private String phone;
    private String email;
}
