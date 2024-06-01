package org.example.model.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.CommonAttribute;

import java.time.LocalDate;

@Getter
@Setter

public class Employee extends CommonAttribute {
    public String position;
    public LocalDate dateOfHire;
    public Status status;
    public Double salary;

    public Employee(int id, String name, String position, LocalDate dateOfHire, Status status, Double salary) {
        super(id, name);
        this.position = position;
        this.dateOfHire = dateOfHire;
        this.status = status;
        this.salary = salary;
    }
}
