package com.epam.task1_3.scanner.api;


import com.epam.task1_3.exceptions.FileDoNotExistException;
import com.epam.task1_3.exceptions.StreamClosingException;


import java.util.ArrayList;

interface Reader {
    ArrayList<String> read(String path) throws FileDoNotExistException, StreamClosingException;
}
