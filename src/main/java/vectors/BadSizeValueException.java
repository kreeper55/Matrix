package vectors;

public class BadSizeValueException extends Throwable {
    public BadSizeValueException() {
    }

    public BadSizeValueException(String message) {
        super(message);
    }

    public BadSizeValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
