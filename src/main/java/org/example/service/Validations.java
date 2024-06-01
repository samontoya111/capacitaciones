package org.example.service;

import org.example.exception.CustomException;
import org.example.model.employee.Employee;

import java.util.List;

public class Validations {
    private Validations() {
    }
    public static final String TEMPLATE = "Error: %s";
    public static final String TEMPLATE_ID = "Error: %s con Id %s no encontrado";
    public static final String TEMPLATE_POSITION = "Error: %s con posicion %s no encontrado";
    public static void isNull(String origin, int id) throws CustomException {
        throw new CustomException(TEMPLATE_ID.formatted(origin, id));
    }
    public static void isEmpty(String origin, List<Employee> list, String id) throws CustomException {
        if(list.isEmpty()) throw new CustomException(TEMPLATE_POSITION.formatted(origin, id));
    }
    public static void isEmpty(String error, String message) throws CustomException {
        if(error.isEmpty()) throw new CustomException(TEMPLATE.formatted(message));
    }
}
