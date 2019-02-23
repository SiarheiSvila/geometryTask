package com.epam.task1_3.scanner;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FileReaderTest {

    private FileReader fileReader = new FileReader();

    @Test
    public void shouldFileReaderReadData1Supplied() {
        //given
        String path = "./src/test/resources/shouldFileReaderReadData1SuppliedTest.txt";

        List<String> expected = Arrays.asList("1 3 5 7", "74 1 2 4");

        //when
        List<String> result = fileReader.read(path);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldFileReaderReadData2Supplied() {
        //given
        String path = "./src/test/resources/shouldFileReaderReadData2SuppliedTest.txt";

        List<String> expected = Arrays.asList("werq", " 7oireb");

        //when
        List<String> result = fileReader.read(path);

        //then
        Assert.assertEquals(expected, result);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldFileReaderReadNoSuchFileSupplied()  {
        //given
        String path = "";

        //when
        List<String> result = fileReader.read(path);

        //then
    }
}
