package com.epam.task1_3.scanner;

import com.epam.task1_3.control.Director;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    final private static Logger LOGGER = Logger.getLogger(Director.class.getName());

    public List<String> read(String path) {

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(path);

            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));

            String line;
            List<String> list = new ArrayList<String>();

            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            return list;
        } catch (FileNotFoundException e) {
            LOGGER.error("File is not found", e);
            throw new IllegalArgumentException();

        } catch (IOException e) {
            LOGGER.error("Error in reading from file", e);
            throw new IllegalArgumentException();

        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("Error in stream closing", e);
                throw new IllegalArgumentException();
            }
        }

    }
}
