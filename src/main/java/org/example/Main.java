package org.example;

import org.example.app.Print;
import org.example.service.AppService;

public class Main {
    public static void main(String[] args) {
        Print.welcome();
        AppService.deployApp();

    }
}