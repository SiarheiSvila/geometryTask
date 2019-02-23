package com.epam.task1_3.control;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;

import org.junit.Assert;
import org.junit.Test;

public class ParserTest {
    private Parser parser = new Parser();

    @Test
    public void shouldParserCreateOvalIntegerVariablesSupplied(){
        //given

        //when
        Oval result = parser.createOval("1 3 5 6  9");

        //then
        Assert.assertEquals(result, new Oval(9, new Point(1,3), new Point(5,6)));
    }

    @Test
    public void shouldParserCreateOvalSomeDoubleVariablesSupplied(){
        //given

        //when
        Oval result = parser.createOval("2.1 1 4 5.8  134");

        //then
        Assert.assertEquals(result, new Oval(134, new Point(2.1,1), new Point(4,5.8)));
    }

    @Test
    public void shouldParserCreateOvalSomeNegativeDoubleVariablesSupplied(){
        //given

        //when
        Oval result = parser.createOval("-0.12 1.34 9.27 -7.95  9034");

        //then
        Assert.assertEquals(result, new Oval(9034, new Point(-0.12,1.34), new Point(9.27,-7.95)));
    }
}
