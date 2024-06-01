package org.example.app.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum OptionMenu {
    DEFAULT,
    CREATE,
    UPDATE,
    LIST,
    SEARCH,
    TOTAL_EMPLOY_OFFICE,
    EXIT;

    public static List<String> getOptions(){
         return Arrays.stream(OptionMenu.values()).map(optionMenu -> "- %s: %s".formatted(optionMenu.ordinal(), optionMenu.name())).toList();
    }

    public static OptionMenu findOptionsByOrdinal(int ordinal){
        Optional<OptionMenu>  optionMenuR = Arrays.stream(OptionMenu.values()).filter(optionMenu -> optionMenu.ordinal() == ordinal).findFirst();
        return optionMenuR.orElse(null);
    }
}
