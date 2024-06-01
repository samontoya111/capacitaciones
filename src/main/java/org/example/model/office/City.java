package org.example.model.office;

import java.util.Arrays;
import java.util.List;

public enum City {
    MEDELLIN,CALI,BOGOTA,MANIZALES;

    public static List<String> getOptions(){
        return Arrays.stream(City.values()).map(city -> "- %s: %s".formatted(city.ordinal(), city.name())).toList();
    }
}
