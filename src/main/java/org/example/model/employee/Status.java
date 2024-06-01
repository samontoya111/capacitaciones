package org.example.model.employee;

import java.util.Arrays;
import java.util.Optional;

public enum Status {
    ACTIVE, INACTIVE;
    public static Status findByName(String name){
        Optional<Status> optionMenuR = Arrays.stream(Status.values()).filter(optionMenu -> optionMenu.name().equals(name)).findFirst();
        return optionMenuR.orElse(null);
    }
}
