package org.pollub.Lab4.Entity;


import lombok.*;

@Data
@AllArgsConstructor
public class Employee {

    private final long id;
    private String name;
    private String address;
    private String phone;
    private String email;
}
