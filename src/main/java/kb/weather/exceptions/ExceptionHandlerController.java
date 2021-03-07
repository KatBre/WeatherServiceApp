package kb.weather.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(EmptyInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleEmptyInputException(EmptyInputException e) {
        System.out.println(e.getMessage());
    }

    @ExceptionHandler(ValueOutOfRangeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void valueOutOfRangeException(ValueOutOfRangeException e) {
        System.out.println(e.getMessage());
    }
}
