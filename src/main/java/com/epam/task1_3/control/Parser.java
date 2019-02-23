package com.epam.task1_3.control;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;

public class Parser {

    private final int NUMBER_OF_POINTS = 2;

    public Oval createOval(String data) {

        Point[] points = new Point[NUMBER_OF_POINTS];

        String[] coordinates = data.split("\\s+");

        Double[] xCoordinate = {Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[2])};
        Double[] yCoordinate = {Double.parseDouble(coordinates[1]), Double.parseDouble(coordinates[3])};

        Integer id = Integer.parseInt(coordinates[4]);

        for (int i = 0; i < NUMBER_OF_POINTS; i++) {
            points[i] = new Point(xCoordinate[i], yCoordinate[i]);

        }

        if (points[0].getX() == points[1].getX() || points[0].getY() == points[1].getY()) {
            return null;
        }

        return new Oval(id, points[0], points[1]);
    }
}
