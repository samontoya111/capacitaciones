package org.example.repository;

import org.example.model.employee.Employee;
import org.example.model.employee.Status;
import org.example.model.office.City;
import org.example.model.office.Office;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OfficeRepository {
    private final Map<String, Office> officeStorage = new HashMap<>();
    public OfficeRepository() {
        officeStorage.put("1", new Office(1, "F2X", City.MEDELLIN,  Arrays.asList(1,2)));
        officeStorage.put("2", new Office(1, "QUIND", City.CALI,  Arrays.asList(3,4,5)));
    }

    public void save(Office office) {
        officeStorage.put(String.valueOf(office.getId()), office);
    }

    public Optional<Office> findById(String id) {
        return Optional.ofNullable(officeStorage.get(id));
    }
    public List<Office> findAll() {
        return officeStorage.values().stream().toList();
    }
    public void deleteById(String id) {
        officeStorage.remove(id);
    }

}
