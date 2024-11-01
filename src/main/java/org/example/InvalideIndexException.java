package org.example;

public class InvalideIndexException extends RuntimeException{
    public InvalideIndexException() {
    }

    public InvalideIndexException(String message) {
        super(message);
    }

    public InvalideIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalideIndexException(Throwable cause) {
        super(cause);
    }

    public InvalideIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
