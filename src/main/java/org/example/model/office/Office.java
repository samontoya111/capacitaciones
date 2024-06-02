package org.example.model.office;

import lombok.Getter;
import lombok.Setter;
import org.example.model.CommonAttribute;

import java.util.List;

@Getter
@Setter
public class Office extends CommonAttribute {
    public Enum city;
    public List<Integer> employeesId;

    public Office(int id, String name, Enum city, List<Integer> employeesId) {
        super(id, name);
        this.city = city;
        this.employeesId = employeesId;
    }
}
