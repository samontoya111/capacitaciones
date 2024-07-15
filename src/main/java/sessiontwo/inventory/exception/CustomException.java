package sessiontwo.inventory.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends Exception {

    private final String message;

    public CustomException(String message) {
        this.message = message;
    }

}
