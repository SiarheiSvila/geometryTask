package com.epam.task1_3.exceptions;

public class OvalCreatingException extends Exception {

    public OvalCreatingException(String message) {
        super(message);
    }

    public OvalCreatingException(String message, Exception e) {
        super(message, e);
    }

    public OvalCreatingException(Exception e) {
        super(e);
    }
}
