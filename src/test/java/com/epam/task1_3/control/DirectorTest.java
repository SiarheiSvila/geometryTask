package com.epam.task1_3.control;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;
import com.epam.task1_3.scanner.FileReader;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class DirectorTest {

    private final List<Oval> EXPECTED_LIST_FOR_TEST_1 = Arrays.asList(new Oval(1, new Point(1,3), new Point(5,7)));
    private final List<Oval> EXPECTED_LIST_FOR_TEST_2 = Arrays.asList(new Oval(2, new Point(1,3), new Point(5,7)),
            new Oval(3, new Point(4.5,2.7), new Point(-0.1,3)));

    @Test
    public void shouldDirectorCreateOvalListOneGoodOvalSupplied(){
        //given
        String path = "./src/test/resources/shouldDirectorCreateOvalListOneGoodOvalSuppliedTest.txt";

        FileReader fileReader = Mockito.mock(FileReader.class);
        when(fileReader.read(anyString())).thenReturn(Arrays.asList("1 3 5 7  1"));

        Validator validator = Mockito.mock(Validator.class);
        when(validator.isDataCorrect(anyString())).thenReturn(true);

        Parser parser = Mockito.mock(Parser.class);
        when(parser.createOval(anyString())).thenReturn(EXPECTED_LIST_FOR_TEST_1.get(0));



        Director director = new Director(fileReader, validator, parser);

        //when
        List<Oval> result = director.createOvalList(path);

        //then
        Assert.assertEquals(EXPECTED_LIST_FOR_TEST_1, result);

        verify(fileReader).read(anyString());
        verify(validator).isDataCorrect(anyString());
        verify(parser).createOval(anyString());

        verifyNoMoreInteractions(fileReader, validator, parser);
    }

    @Test
    public void shouldDirectorCreateOvalListOneGoodAndTwoBadOvalsSupplied(){
        //given
        String path = "./src/test/resources/shouldDirectorCreateOvalListOneGoodAndTwoBadOvalsSuppliedTest.txt";

        FileReader fileReader = Mockito.mock(FileReader.class);
        when(fileReader.read(anyString())).thenReturn(Arrays.asList("1 3 5 7  2", "4.5 2.7 -0.1 3  3"));

        Validator validator = Mockito.mock(Validator.class);
        when(validator.isDataCorrect(anyString())).thenReturn(true);

        Parser parser = Mockito.mock(Parser.class);
        when(parser.createOval("1 3 5 7  2")).thenReturn(EXPECTED_LIST_FOR_TEST_2.get(0));
        when(parser.createOval("4.5 2.7 -0.1 3  3")).thenReturn(EXPECTED_LIST_FOR_TEST_2.get(1));


        Director director = new Director(fileReader, validator, parser);

        //when
        List<Oval> result = director.createOvalList(path);

        //then
        Assert.assertEquals(EXPECTED_LIST_FOR_TEST_2, result);

        verify(fileReader).read(anyString());
        verify(validator).isDataCorrect("1 3 5 7  2");
        verify(validator).isDataCorrect("4.5 2.7 -0.1 3  3");
        verify(parser).createOval("1 3 5 7  2");
        verify(parser).createOval("4.5 2.7 -0.1 3  3");

        verifyNoMoreInteractions(fileReader, validator, parser);
    }

}
