package org.example.model.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.CommonAttribute;

import java.time.LocalDate;

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
