package sessiontwo.inventory.anotations;

import sessiontwo.inventory.anotations.enums.EnumMethodWebService;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SaveHistorical {
    EnumMethodWebService method();
}
