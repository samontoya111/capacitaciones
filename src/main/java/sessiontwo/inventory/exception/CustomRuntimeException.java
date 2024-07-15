package sessiontwo.inventory.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomRuntimeException extends RuntimeException {

    private final String message;

    public CustomRuntimeException(String message) {
        this.message = message;
    }

}
