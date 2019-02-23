package com.epam.task1_3.exceptions;

public class StreamClosingException extends ScannerException{
    public StreamClosingException(Exception e){
        super(e);
    }

    public StreamClosingException(String message, Exception e){
        super(message, e);
    }
}
