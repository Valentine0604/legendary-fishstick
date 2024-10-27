package org.pollub.Lab4.DTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmployeeDTO {
    private long id;
    private String name;
    private String address;
    private String phone;
    private String email;
}
