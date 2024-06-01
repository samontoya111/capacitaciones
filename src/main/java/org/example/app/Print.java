package org.example.app;

import lombok.extern.slf4j.Slf4j;
import org.example.utils.DateUtils;

import java.util.List;

@Slf4j
public class Print {
    private Print() {
    }

    public static final String TEMPLATE = "Resultado: %s ";

    public static void resultIs(String text){
      log.info(TEMPLATE.formatted(text));
    }
    public static void message(String text){
      log.info(text);
    }
    public static void resultIs(List<String> texts){
        texts.forEach(log::info);
    }
    public static void welcome(){
      log.info("Este es el sistema de Gestion de Empleados. -- %s".formatted(DateUtils.now()));
    }


}
