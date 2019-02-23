package com.epam.task1_3.exceptions;

public class OvalNotFoundException extends Exception {

    public OvalNotFoundException(Exception e){
        super(e);
    }

    public OvalNotFoundException(String message, Exception e){
        super(message, e);
    }

    public OvalNotFoundException(String message){
        super(message);
    }
}
