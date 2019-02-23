package com.epam.task1_3.repository.comparator.sortByCoordinate;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;

import java.util.Comparator;

public class SortByPointXCoordinateX implements Comparator<Oval> {

    @Override
    public int compare(Oval o1, Oval o2) {
        if (o1 == null || o2 == null) {
            throw new IllegalArgumentException("Error. Oval can't be null");
        }

        Point pointXOval1 = o1.getPointX();
        Point pointXOval2 = o2.getPointX();

        double coordinateXPointXOval1 = pointXOval1.getX();
        double coordinateXPointXOval2 = pointXOval2.getX();

        return coordinateXPointXOval1 < coordinateXPointXOval2 ? -1 : coordinateXPointXOval1 == coordinateXPointXOval2 ? 0 : 1;
    }
}
