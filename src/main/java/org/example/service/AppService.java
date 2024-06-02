package org.example.service;

import org.example.repository.EmployeeRepository;
import org.example.repository.OfficeRepository;
import org.example.service.menu.PrincipalMenu;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    private static PrincipalMenu principal = new PrincipalMenu();

    protected AppService() {
    }

    public static void deployApp() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        OfficeRepository officeRepository = new OfficeRepository();
        OfficeService officeService = new OfficeService(officeRepository);

        principal.display(employeeService, officeService);
    }
}
