package kb.weather.exceptions;

public class ValueOutOfRangeException extends RuntimeException {
    public ValueOutOfRangeException(String message) {
        super(message);
    }
}
