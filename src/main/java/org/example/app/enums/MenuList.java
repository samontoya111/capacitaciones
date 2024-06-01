package org.example.app.enums;

import org.example.exception.CustomException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum MenuList {
    DEFAULT,
    ALL,
    BY_ID,
    BY_POSITION,
    EXIT;

    public static List<String> getOptions(){
         return Arrays.stream(MenuList.values()).filter(optionMenu -> optionMenu.ordinal() != 0).map(optionMenu -> " %s: %s ".formatted(optionMenu.ordinal(), optionMenu.name())).toList();
    }

    public static MenuList findOptionsByOrdinal(int ordinal) throws CustomException {
        Optional<MenuList>  optionMenuReturn = Arrays.stream(MenuList.values()).filter(optionMenu -> optionMenu.ordinal() == ordinal).findFirst();
        if(optionMenuReturn.isEmpty()){
            throw new CustomException("No hay una opcion valida");
        }
        return optionMenuReturn.get();
    }
}
