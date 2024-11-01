package org.example;

public class IntegerListIsFUllException extends RuntimeException{
    public IntegerListIsFUllException() {
    }

    public IntegerListIsFUllException(String message) {
        super(message);
    }

    public IntegerListIsFUllException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntegerListIsFUllException(Throwable cause) {
        super(cause);
    }

    public IntegerListIsFUllException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
