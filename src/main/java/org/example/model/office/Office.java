package org.example.model.office;

import lombok.Getter;
import lombok.Setter;
import org.example.model.CommonAttribute;

import java.util.List;

@Getter
@Setter
public class Office extends CommonAttribute {
    public Enum city;
    public List<Integer> EmployeesId;

    public Office(int id, String name, Enum city, List<Integer> EmployeesId) {
        super(id, name);
        this.city = city;
        this.EmployeesId = EmployeesId;
    }
}
