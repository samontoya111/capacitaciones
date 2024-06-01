package org.example.app;

import lombok.extern.slf4j.Slf4j;
import org.example.app.enums.OptionMenu;
import org.example.model.employee.Employee;
import org.example.repository.EmployeeRepository;
import org.example.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.app.enums.OptionMenu.DEFAULT;
import static org.example.app.enums.OptionMenu.EXIT;

@Slf4j
public class Print {
    public static void text(String text){
      log.info(text);
    }
    public static void text(List<String> texts){
        texts.forEach(log::info);
    }
    public static void welcome(){
      log.info("Este es el sistema de Gestion de Empleados.");
    }


}
