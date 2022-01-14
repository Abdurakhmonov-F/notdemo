package com.example.notdemo.exception;

public class DoesNotExistException extends RuntimeException{
    public DoesNotExistException() {}

    public DoesNotExistException(final String message) {
        super(message);
    }

    public DoesNotExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DoesNotExistException(final Throwable cause) {
        super(cause);
    }

    public DoesNotExistException(
            final String message,
            final Throwable cause,
            final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
