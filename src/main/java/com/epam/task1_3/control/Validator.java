package com.epam.task1_3.control;

public class Validator {

    private final String TWO_POINTS_AND_ID_REGEX = "((-?)(0|([1-9][0-9]*))(\\.[0-9]+)?\\s){4}\\s[1-9]\\d*";

    public boolean isDataCorrect(String data) {

        return data.matches(TWO_POINTS_AND_ID_REGEX);
    }
}
