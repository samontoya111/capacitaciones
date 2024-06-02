package org.example.app.enums;

import org.example.exception.CustomException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum OptionMenu {
    DEFAULT,
    TEST_ADD,
    TEST_UPDATE,
    CREATE,
    UPDATE,
    LIST,
    SEARCH_OFFICE_BY_ID,
    TOTAL_EMPLOY_OFFICE,
    EXIT;

    public static List<String> getOptions(){
         return Arrays.stream(OptionMenu.values()).filter(optionMenu -> optionMenu.ordinal() != 0).map(optionMenu -> " %s: %s ".formatted(optionMenu.ordinal(), optionMenu.name())).toList();
    }

    public static OptionMenu findOptionsByOrdinal(int ordinal) throws CustomException {
        Optional<OptionMenu>  optionMenuReturn = Arrays.stream(OptionMenu.values()).filter(optionMenu -> optionMenu.ordinal() == ordinal).findFirst();
        if(optionMenuReturn.isEmpty()){
            throw new CustomException("No hay una opcion valida");
        }
        return optionMenuReturn.get();
    }
}
