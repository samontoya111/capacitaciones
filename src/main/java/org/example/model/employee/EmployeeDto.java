package org.example.model.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDto{
    public int id;
    public String name;
    public String position;
    public String dateOfHire;
    public String status;
    public Double salary;
}
