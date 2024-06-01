package org.example;

import org.example.app.Print;
import org.example.service.AppService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
/**
 * //{"id":4,"name":"Santi","position":"A","dateOfHire":"02-01-2024","status":"ACTIVE","salary":1000000.0}
 */


        Print.welcome();
        AppService.deployApp();
    }
}