package org.example.service;

import org.example.exception.CustomException;
import org.example.model.employee.Employee;

import java.util.List;
import java.util.Objects;

public class Validations {
    private Validations() {
    }
    public static final String TEMPLATE = "Error: %s";
    public static final String TEMPLATE_ID = "Error: %s con Id %s no encontrado";
    public static final String TEMPLATE_POSITION = "Error: %s con posicion %s no encontrado";
    public static String isNull(String origin, int id) {
        return (TEMPLATE_ID.formatted(origin, id));
    }
    public static void isEmpty(String origin, List<Employee> list, String id) throws CustomException {
        if(list.isEmpty()) throw new CustomException(TEMPLATE_POSITION.formatted(origin, id));
    }
    public static void isEmpty(String error, String message) throws CustomException {
        if(error.isEmpty()) throw new CustomException(TEMPLATE.formatted(message));
    }
    static void validateEmployee(Employee employee) throws CustomException {
        StringBuilder stringBuilder = new StringBuilder();
        String template = "-%s necesario-";
        if(Objects.isNull(employee.getId())) stringBuilder.append(template.formatted("id"));
        if(Objects.isNull(employee.getName())) stringBuilder.append(template.formatted("name"));
        if(Objects.isNull(employee.getStatus())) stringBuilder.append(template.formatted("status"));
        if(Objects.isNull(employee.getSalary())) stringBuilder.append(template.formatted("salario"));
        if(Objects.isNull(employee.getDateOfHire())) stringBuilder.append(template.formatted("Fecha"));

        if (!stringBuilder.isEmpty()) throw new CustomException("Error empleado sin atributos: %s".formatted(stringBuilder));
    }
}
