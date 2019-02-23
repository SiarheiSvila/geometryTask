package com.epam.task1_3.control;


import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

    private Validator validator = new Validator();

    @Test
    public void shouldValidatorIsDataCorrectIntegerSupplied(){
        //given

        //when
        boolean result = validator.isDataCorrect("1 4 5 6  23");

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void shouldValidatorIsDataCorrectSomeNegativeVariablesSupplied(){
        //given

        //when
        boolean result = validator.isDataCorrect("1.2 -4 -0.12 6.9032  95");

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void shouldValidatorIsDataCorrectZeroesSupplied(){
        //given

        //when
        boolean result = validator.isDataCorrect("0 0 0 0  1");

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void shouldValidatorIsDataCorrectNoFractionSupplied(){
        //given

        //when
        boolean result = validator.isDataCorrect("1. 3 6 7  8");

        //then
        Assert.assertTrue(!result);
    }

    @Test
    public void shouldValidatorIsDataCorrectNoIdSupplied(){
        //given

        //when
        boolean result = validator.isDataCorrect("1 2 3 6");


        //then
        Assert.assertTrue(!result);
    }

    @Test
    public void shouldValidatorIsDataCorrectThreeVariablesSupplied(){
        //given

        //when
        boolean result = validator.isDataCorrect("1 2 3 ");


        //then
        Assert.assertTrue(!result);
    }

    @Test
    public void shouldValidatorIsDataCorrectTwoVariablesSupplied(){
        //given

        //when
        boolean result = validator.isDataCorrect("1 2 ");


        //then
        Assert.assertTrue(!result);
    }

    @Test
    public void shouldValidatorIsDataCorrectOneVariableSupplied(){
        //given

        //when
        boolean result = validator.isDataCorrect("1 ");


        //then
        Assert.assertTrue(!result);
    }

    @Test
    public void shouldValidatorIsDataCorrectNoVariablesSupplied(){
        //given

        //when
        boolean result = validator.isDataCorrect("");


        //then
        Assert.assertTrue(!result);
    }
}
