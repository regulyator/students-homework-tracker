package com.regulyator.hwtracker.data.exception;

public class DataException extends RuntimeException {

    public DataException() {
        super();
    }

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }
}
