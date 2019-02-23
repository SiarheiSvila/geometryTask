package com.epam.task1_3.control;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.scanner.FileReader;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Director {
    final private static Logger LOGGER = Logger.getLogger(Director.class.getName());

    private final FileReader fileReader;
    private final Validator validator;
    private final Parser parser;


    public Director(FileReader fileReader, Validator validator, Parser parser) {
        this.fileReader = fileReader;
        this.validator = validator;
        this.parser = parser;
    }

    public List<Oval> createOvalList(String path) {

        List<Oval> ovalList = new ArrayList<Oval>();

        List<String> data = fileReader.read(path);

        for (String line : data) {

            //проверяем на валидность сразу всю строку
            //создаем объект и добавляем его в List

            if (validator.isDataCorrect(line)) {
                Oval oval = parser.createOval(line);

                if (oval == null) {
                    continue;
                }

                ovalList.add(oval);
            }

        }

        if (ovalList.size() == 0) {
            LOGGER.error("Error in creating an oval: ");
            throw new IllegalArgumentException("Error. No suitable data found");
        }

        return ovalList;

    }
}
