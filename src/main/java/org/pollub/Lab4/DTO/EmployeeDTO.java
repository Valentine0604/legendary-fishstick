package org.pollub.Lab4.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.pollub.Lab4.Entity.Employee;

@Getter
@ToString
public class EmployeeDTO {
    private final long id;
    private final String name;
    private final String address;
    private final String phone;
    private final String email;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.address = employee.getAddress();
        this.phone = employee.getPhone();
        this.email = employee.getEmail();
    }

    public Employee toEntity() {
        return new Employee(this.id, this.name, this.address, this.phone, this.email);
    }
}
