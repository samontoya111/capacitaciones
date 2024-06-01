package org.example.service;

import org.example.app.Print;
import org.example.app.enums.MenuList;
import org.example.app.enums.OptionMenu;
import org.example.repository.EmployeeRepository;
import org.example.repository.OfficeRepository;

import java.util.Scanner;

import static org.example.app.enums.OptionMenu.DEFAULT;
import static org.example.app.enums.OptionMenu.EXIT;

public class AppService {

    public static void deployApp(){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        OfficeRepository officeRepository = new OfficeRepository();
        OfficeService officeService = new OfficeService(officeRepository);

        Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
        String select; //opción elegida del usuario
        OptionMenu optionMenu = DEFAULT;

        String id;
        // Mientras la opción elegida sea 0, preguntamos al usuario
        while(optionMenu != EXIT) {
            //Try catch para evitar que el programa termine si hay un error
            try{
                Print.text("Seleccione una opcion");
                Print.text(OptionMenu.getOptions().toString());

                //Recoger una variable por consola
                select = scanner.nextLine();
                optionMenu = OptionMenu.findOptionsByOrdinal(Integer.valueOf(select));

                //Ejemplo de switch case en Java
                switch(optionMenu) {
                    case CREATE:
                        Print.text("ingrese json con la informacion del empleado");
                        String json = scanner.nextLine();
                        Print.text("creando empleado");

                        employeeService.addEmployee(employeeService.getEmployeeFromJson(json));

                        break;
                    case UPDATE:
                        Print.text("Actualizacion de posision");
                        Print.text("ingrese id del empleado");
                        id = scanner.nextLine();
                        Print.text("ingrese posision del empleado");
                        String position = scanner.nextLine();
                        employeeService.updatePositionOfEmployee(Integer.valueOf(id), position);

                        break;
                    case LIST:
                        menuList(employeeService);
                        break;
                    case SEARCH:
                        Print.text("Buscar  oficina por id de empleado");
                        Print.text("ingrese id del empleado");
                        id = scanner.nextLine();
                        Print.text(officeService.getOfficeByEmployeeId(Integer.valueOf(id)).name);
                        break;

                    case TOTAL_EMPLOY_OFFICE:
                        Print.text("Buscar  oficina por id de empleado");
                        Print.text("ingrese id de de la oficina");
                        id = scanner.nextLine();
                        Print.text(String.valueOf(officeService.getQuantityEmployeesByOfficeId(Integer.valueOf(id))));
                        break;

                    case EXIT:
                        Print.text("Hasta pronto");
                        break;
                    default:
                        Print.text("Opcion no reconocido");
                        break;
                }

                Print.text("\n"); //Mostrar un salto de línea en Java

            }catch(Exception e){
                Print.text("Uoop! Error!");
                Print.text(e.getMessage());
            }
        }
    }

    private static void menuList(EmployeeService employeeService){
        Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
        String select; //opción elegida del usuario
        MenuList menuList = MenuList.DEFAULT;

        // Mientras la opción elegida sea 0, preguntamos al usuario
        while(menuList != MenuList.EXIT) {
            //Try catch para evitar que el programa termine si hay un error
            try{
                Print.text("Seleccione una opcion de la lista");
                Print.text(MenuList.getOptions().toString());

                //Recoger una variable por consola
                select = scanner.nextLine();
                menuList = MenuList.findOptionsByOrdinal(Integer.valueOf(select));

                //Ejemplo de switch case en Java
                switch(menuList) {
                    case ALL:
                        Print.text("Lista de empleados");
                        Print.text(employeeService.getEmployees());
                        break;
                    case BY_ID:
                        Print.text("Ingrese el Id del empleado");
                        select = scanner.nextLine();
                        Print.text(employeeService.getEmployeesById(Integer.valueOf(select)));
                        break;
                    case BY_POSITION:
                        Print.text("Ingrese el Posicion del empleado");
                        select = scanner.nextLine();
                        Print.text(employeeService.getEmployeesByPosition(select));
                        break;
                    case EXIT:
                        Print.text("Hasta pronto");
                        break;
                    default:
                        Print.text("Opcion no reconocido");
                        break;
                }

                Print.text("\n"); //Mostrar un salto de línea en Java

            }catch(Exception e){
                Print.text("Uoop! Error!");
            }
        }

    }

}
