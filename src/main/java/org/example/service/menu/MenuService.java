package org.example.service.menu;

import org.example.app.Print;
import org.example.exception.CustomException;
import org.example.service.Validations;

import java.util.Scanner;

public class MenuService {
    private MenuService(){}
    static String selectOption(String message) throws CustomException {
        Scanner scanner = new Scanner(System.in);
        Print.message(message);
        String capturedOption =  scanner.nextLine();
        Validations.isEmpty(capturedOption,"selecione una opcion valida");
        return capturedOption;
    }
}
