package exception;

public class UnsupportedFileTypeException extends Exception {
    public UnsupportedFileTypeException() {
    }

    public UnsupportedFileTypeException(String message) {
        super(message);
    }

    public UnsupportedFileTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}


