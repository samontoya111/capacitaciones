package org.example.service;

import org.example.app.Print;
import org.example.exception.CustomException;
import org.example.model.employee.Employee;
import org.example.model.employee.EmployeeDto;
import org.example.model.employee.Status;
import org.example.repository.EmployeeRepository;
import org.example.utils.DateUtils;
import org.example.utils.JsonUtils;

import java.util.List;
import java.util.Optional;
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) throws CustomException {
        Validations.validateEmployee(employee);
        employeeRepository.save(employee);
        Print.message("creado con exito");
    }

    public List<String> getEmployees(){
        return printEmpleados(employeeRepository.findAll());
    }
    public Employee getEmployeeById(int id) throws CustomException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()){
            throw new CustomException(Validations.isNull("Empleado", id));
        }

        return employee.get();

    }
    public String getJsonEmployeesById(int id) throws CustomException {
        return JsonUtils.objectToJson(getEmployeeById(id));
    }

    public String getEmployeesByPosition(String  position) throws CustomException {
        List<Employee> list = employeeRepository.getEmployeesByPosition(position);
        Validations.isEmpty("Employ", list, position);
        return JsonUtils.objectToJson(list);
    }

    public Employee getEmployeeFromJson(String jsonEmploy) {
        EmployeeDto employeeDto = (EmployeeDto) JsonUtils.jsonToObject(jsonEmploy, EmployeeDto.class);
        return new Employee(employeeDto.id, employeeDto.name, employeeDto.position, DateUtils.getDateByFormat(employeeDto.dateOfHire), Status.findByName(employeeDto.status), employeeDto.salary);
    }

    public void updatePositionOfEmployee(int id, String position) throws CustomException {
        Employee employee = getEmployeeById(id);

        if (employee != null) {
            employee.setPosition(position);
        } else {
            Validations.isNull("Empleado", id);
        }
        updateEmployee(employee);
    }
    public void updateEmployee(Employee employee) throws CustomException {
        Validations.validateEmployee(employee);
        employeeRepository.save(employee);
    }

    public List<String> printEmpleados(List<Employee> employes) {
        String data = "Id: %d,  Nombre: %s,  Status: %s,  Posicion: %s,  Fecha de contratacion: %s,  salario: %s ";
        return employes.stream().map(employee -> data.formatted(employee.getId(), employee.getName(), employee.getStatus().name(), employee.getPosition(), employee.getDateOfHire(), employee.getSalary())).toList();
    }
}
