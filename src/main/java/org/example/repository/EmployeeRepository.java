package org.example.repository;

import org.example.model.employee.Employee;
import org.example.model.employee.Status;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EmployeeRepository {
    private final Map<String, Employee> employeeStorage = new HashMap<>();
    public EmployeeRepository() {
        employeeStorage.put("1", new Employee(1, "Santi", "A", LocalDate.now(), Status.ACTIVE,1000000D));
        employeeStorage.put("2", new Employee(2, "Andres", "B", LocalDate.now(), Status.ACTIVE,2000000D));
        employeeStorage.put("3", new Employee(3, "Carlos", "C", LocalDate.now(), Status.ACTIVE,4000000D));
    }

    public void save(Employee employee) {
        employeeStorage.put(String.valueOf(employee.getId()), employee);
    }

    public Optional<Employee> findById(int id) {
        return Optional.ofNullable(employeeStorage.get(String.valueOf(id)));
    }
    public List<Employee> findAll() {
        return employeeStorage.values().stream().toList();
    }
    public List<Employee> getEmployeesByPosition(String position) {
       return findAll().stream().filter(employee -> employee.getPosition().equals(position)).toList();
    }
    public void updateById(int id, Employee employee) {
        employeeStorage.put(String.valueOf(id), employee);
    }

}
