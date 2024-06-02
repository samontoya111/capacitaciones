package org.example.service.menu;

import org.example.service.EmployeeService;
import org.example.service.OfficeService;

public interface Menu {
    void display(EmployeeService employeeService, OfficeService officeService);
}
