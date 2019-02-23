package com.epam.task1_3.exceptions;

public class FileDoNotExistException extends ScannerException {
    public FileDoNotExistException(Exception e){
        super(e);
    }

    public FileDoNotExistException(String message, Exception e){
        super(message, e);
    }
}
