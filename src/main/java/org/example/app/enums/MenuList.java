package org.example.app.enums;

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
         return Arrays.stream(MenuList.values()).map(optionMenu -> "- %s: %s".formatted(optionMenu.ordinal(), optionMenu.name())).toList();
    }

    public static MenuList findOptionsByOrdinal(int ordinal){
        Optional<MenuList>  optionMenuR = Arrays.stream(MenuList.values()).filter(optionMenu -> optionMenu.ordinal() == ordinal).findFirst();
        return optionMenuR.orElse(null);
    }
}
