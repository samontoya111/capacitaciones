package org.example.service;

import org.example.model.employee.Employee;
import org.example.model.employee.EmployeeDto;
import org.example.model.employee.Status;
import org.example.repository.EmployeeRepository;
import org.example.utils.DateUtils;
import org.example.utils.JsonUtils;

import java.io.IOException;
import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    public List<String> getEmployees(){
        return printEmpleados(employeeRepository.findAll());
    }
    public String getEmployeesById(int id) {
        return JsonUtils.objectToJson(employeeRepository.findById(id).orElse(null));
    }
    public String getEmployeesByPosition(String  position) {
        return JsonUtils.objectToJson(employeeRepository.getEmployeesByPosition(position));
    }

    public Employee getEmployeeFromJson(String jsonEmploy) {
        EmployeeDto employeeDto = (EmployeeDto) JsonUtils.jsonToObject(jsonEmploy, EmployeeDto.class);
        return new Employee(employeeDto.id, employeeDto.name, employeeDto.position, DateUtils.getDateByFormat(employeeDto.dateOfHire), Status.findByName(employeeDto.status), employeeDto.salary);
    }

    public void updatePositionOfEmployee(int id, String position){
        Employee employee = employeeRepository.findById(id).orElse(null);
        employee.setPosition(position);
        employeeRepository.updateById(id, employee);
    }

    public List<String> printEmpleados(List<Employee> employes) {
        String data = "Id: %d,  Nombre: %s,  Status: %s,  Posicion: %s,  Fecha de contratacion: %s,  salario: %s ";
        return employes.stream().map(employee -> data.formatted(employee.getId(), employee.getName(), employee.getStatus().name(), employee.getPosition(), employee.getDateOfHire(), employee.getSalary())).toList();
    }

}
