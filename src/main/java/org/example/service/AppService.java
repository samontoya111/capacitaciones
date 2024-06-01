package org.example.service;

import org.example.app.Print;
import org.example.app.enums.MenuList;
import org.example.app.enums.OptionMenu;
import org.example.exception.CustomException;
import org.example.repository.EmployeeRepository;
import org.example.repository.OfficeRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

import static org.example.app.enums.OptionMenu.DEFAULT;
import static org.example.app.enums.OptionMenu.EXIT;

@Service
public class AppService {
    protected AppService() {
    }

    public static void deployApp() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        OfficeRepository officeRepository = new OfficeRepository();
        OfficeService officeService = new OfficeService(officeRepository);

        String select; //opción elegida del usuario
        OptionMenu optionMenu = DEFAULT;

        String id;
        // Mientras la opción elegida sea 0, preguntamos al usuario
        while(optionMenu != EXIT) {
            //Try catch para evitar que el programa termine si hay un error
            try{
                Print.message("Seleccione una opcion");
                Print.message(OptionMenu.getOptions().toString());

                //Recoger una variable por consola
                select = selectOption("Esperando opcion");
                optionMenu = OptionMenu.findOptionsByOrdinal(Integer.parseInt(select));

                switch(optionMenu) {
                    case CREATE:
                        String textBlock = """
    Ingrese json con la informacion del empleado
        Este es un ejemplo
            {"id":4,"name":"Santi","position":"A","dateOfHire":"02-01-2024","status":"ACTIVE","salary":1000000.0}
""";
                        String json = selectOption(textBlock);
                        employeeService.addEmployee(employeeService.getEmployeeFromJson(json));

                        break;
                    case UPDATE:
                        Print.message("Actualizacion de posision");
                        id = selectOption("Ingrese id del empleado");
                        String position =selectOption("Ingrese posision del empleado");
                        employeeService.updatePositionOfEmployee(Integer.parseInt(id), position);
                        break;
                    case LIST:
                        menuList(employeeService);
                        break;
                    case SEARCH:
                        Print.message("Buscar  oficina por id de empleado");
                        id = selectOption("Ingrese id del empleado");
                        Print.resultIs(officeService.getOfficeByEmployeeId(Integer.parseInt(id)).name);
                        break;

                    case TOTAL_EMPLOY_OFFICE:
                        Print.message("Buscar  oficina por id de empleado");
                        id = selectOption("ingrese id de de la oficina");
                        Print.resultIs(String.valueOf(officeService.getQuantityEmployeesByOfficeId(Integer.parseInt(id))));
                        break;

                    case EXIT:
                        Print.message("Hasta pronto");
                        break;
                    default:
                        Print.message("Opcion no reconocido");
                        break;
                }

                Print.message("\n");

            } catch(CustomException e){
                Print.resultIs(String.format("Uoop! %s",e.getMessage()));
            } catch (Exception e){
                Print.resultIs(String.format("Perdon error no controlado! %s",e.getMessage()));
            }
        }
    }

    private static void menuList(EmployeeService employeeService){
        String select;
        MenuList menuList = MenuList.DEFAULT;

        while(menuList != MenuList.EXIT) {
            try{
                Print.message("Seleccione una opcion de la lista");
                Print.message(MenuList.getOptions().toString());


                //Recoger una variable por consola
                select = selectOption("Esperando opcion");
                menuList = MenuList.findOptionsByOrdinal(Integer.parseInt(select));

                //Ejemplo de switch case en Java
                switch(menuList) {
                    case ALL:
                        Print.message("Lista de empleados");
                        Print.resultIs(employeeService.getEmployees());
                        break;
                    case BY_ID:
                        select = selectOption ("Ingrese el Id del empleado");
                        Print.resultIs(employeeService.getEmployeesById(Integer.parseInt(select)));
                        break;
                    case BY_POSITION:
                        select = selectOption ("Ingrese el Posicion del empleado");
                        Print.resultIs(employeeService.getEmployeesByPosition(select));
                        break;
                    case EXIT:
                        Print.message("Hasta pronto");
                        break;
                    default:
                        Print.message("Opcion no reconocido");
                        break;
                }

                Print.message("\n");

            }catch(CustomException e){
                Print.resultIs(String.format("Uoop! %s",e.getMessage()));
            } catch (Exception e){
                Print.resultIs(String.format("Perdon error no controlado! %s",e.getMessage()));
            }
        }
    }

    private static String selectOption(String message) throws CustomException {
        Scanner scanner = new Scanner(System.in);
        Print.message(message);
        String capturedOption =  scanner.nextLine();
        Validations.isEmpty(capturedOption,"selecione una opcion valida");
        return capturedOption;
    }
}
