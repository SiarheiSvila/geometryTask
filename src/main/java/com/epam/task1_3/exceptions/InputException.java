package com.epam.task1_3.exceptions;

public class InputException extends ScannerException {
    public InputException(Exception e){
        super(e);
    }

    public InputException(String message, Exception e){
        super(message, e);
    }
}
