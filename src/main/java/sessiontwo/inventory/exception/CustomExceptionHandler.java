package sessiontwo.inventory.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sessiontwo.inventory.constants.Constants;
import sessiontwo.inventory.rest.response.ResponseObject;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> processException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return buildResponseEntity(
                new ResponseObject<>(Constants.EXCEPTION_CODE,Constants.FAIL_MESSAGE + ": " + ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> processFlypassExceptionHandler(CustomException ex) {
        log.error(ex.getMessage());
        return buildResponseEntity(new ResponseObject<>(Constants.FAIL_CODE, ex.getMessage()), HttpStatus.OK);
    }

    private ResponseEntity<Object> buildResponseEntity(ResponseObject<Void> responseObject, HttpStatus status) {
        return new ResponseEntity<>(responseObject, status);
    }

}