package com.epam.task1_3.observer;

import com.epam.task1_3.action.Calculation;
import com.epam.task1_3.entity.OvalParameters;
import com.epam.task1_3.entity.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


import static org.mockito.Mockito.when;

public class OvalObserverTest {

    private final static double AREA = 100.0;
    private final static double PERIMETER = 10.0;

    private final static double DELTA = 0.001;

    private final static OvalObservable OVAL_OBSERVABLE = new OvalObservable(
            1234,
            new Point(1,3),
            new Point(-3,4.3)
    );


    @Test
    public void shouldUpdateAreaAndPerimeterWhenOvalSupplied(){
        //given
        Calculation calculation = Mockito.mock(Calculation.class);
        when(calculation.getArea(OVAL_OBSERVABLE)).thenReturn(AREA);
        when(calculation.getPerimeter(OVAL_OBSERVABLE)).thenReturn(PERIMETER);

        OvalObserver observer = OvalObserver.getInstance(calculation);

        //when
        observer.update(OVAL_OBSERVABLE);

        //then
        //Assert.assertNotNull(actual);
        OvalParameters actual = observer.getParameters(OVAL_OBSERVABLE.getId());

        Assert.assertEquals(AREA, actual.getArea(), DELTA);
        Assert.assertEquals(PERIMETER, actual.getPerimeter(), DELTA);

        Mockito.verify(calculation).getArea(OVAL_OBSERVABLE);
        Mockito.verify(calculation).getPerimeter(OVAL_OBSERVABLE);
        Mockito.verifyNoMoreInteractions(calculation);
    }
}
