package com.epam.task1_3.action;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;
import com.epam.task1_3.observer.OvalObservable;
import org.junit.Assert;
import org.junit.Test;

public class CalculationTest {

    private Calculation calculation = new Calculation();

    private final static double DELTA = 0.001;

    @Test
    public void shouldCalculationGetAreaTwoAndOneLengthSupplied()  {
        //given

        //when
        double result = calculation.getArea(new Oval(1, new Point(1,2), new Point(3,1)));
        new OvalObservable(
                1234,
                new Point(1,3),
                new Point(-3,4.3)
        );

        //then
        Assert.assertEquals(6.2832, result, DELTA);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldCalculationGetAreaNullSupplied()  {
        //given

        //when
        double result = calculation.getArea(null);

        //then

    }


    @Test
    public void shouldCalculationGetPerimeterTwoAndOneLengthSupplied()  {
        //given

        //when
        double result = calculation.getPerimeter(new Oval(2, new Point(1,2), new Point(3,1)));


        //then
        Assert.assertEquals(9.9346, result, DELTA);
    }


    @Test (expected = IllegalArgumentException.class)
    public void shouldCalculationGetPerimeterNullSupplied()  {
        //given

        //when
        double result = calculation.getPerimeter(null);

        //then

    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldCalculationIsCircleNullSupplied() {

        boolean result = calculation.isCircle(null);
    }


    @Test
    public void shouldCalculationIsCircleCircleSupplied() {
        //given


        //when
        boolean result = calculation.isCircle(new Oval(3, new Point(1,3), new Point(3,1)));


        //then
        Assert.assertTrue(result);
    }


    @Test
    public void shouldCalculationIsCircleOvalSupplied() {
        //given

        //when
        boolean result = calculation.isCircle(new Oval(4, new Point(1,2), new Point(3,1)));


        //then
        Assert.assertTrue(!result);
    }


    @Test (expected = IllegalArgumentException.class)
    public void shouldCalculationIsOxCrossedNullSupplied() {

        boolean result = calculation.isOxCrossed(null);
    }


    @Test
    public void shouldCalculationIsOxCrossedIsCrossedSupplied() {
        //given

        //when
        boolean result = calculation.isOxCrossed(new Oval(5, new Point(2,-3), new Point(3,1)));


        //then
        Assert.assertTrue(result);
    }


    @Test
    public void shouldCalculationIsOxCrossedPointBelongsToOxSupplied()  {
        //given

        //when
        boolean result = calculation.isOxCrossed(new Oval(6, new Point(1,3), new Point(3,0)));


        //then
        Assert.assertTrue(result);
    }


    @Test
    public void shouldCalculationIsOxCrossedIsNotCrossedSupplied()  {
        //given

        //when
        boolean result = calculation.isOxCrossed(new Oval(7, new Point(2,3), new Point(3,-1)));


        //then
        Assert.assertTrue(result);
    }


    @Test (expected = IllegalArgumentException.class)
    public void shouldCalculationIsOyCrossedNullSupplied() {

        boolean result = calculation.isOyCrossed(null);
    }


    @Test
    public void shouldCalculationIsOyCrossedIsCrossedSupplied()  {
        //given

        //when
        boolean result = calculation.isOyCrossed(new Oval(8, new Point(-2,3), new Point(3,1)));


        //then
        Assert.assertTrue(result);
    }


    @Test
    public void shouldCalculationIsOyCrossedPointBelongsToOySupplied()  {
        //given

        //when
        boolean result = calculation.isOyCrossed(new Oval(9, new Point(0,3), new Point(3,1)));


        //then
        Assert.assertTrue(result);
    }


    @Test
    public void shouldCalculationIsOyCrossedIsNotCrossedSupplied()  {
        //given

        //when
        boolean result = calculation.isOyCrossed(new Oval(10, new Point(-2,3), new Point(3,1)));


        //then
        Assert.assertTrue(result);
    }
}