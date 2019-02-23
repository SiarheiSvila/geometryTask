package com.epam.task1_3.exceptions;

public class ScannerException extends OvalCreatingException {

    public ScannerException(Exception e){
        super(e);
    }

    public ScannerException(String message, Exception e){
        super(message, e);
    }
}
