package com.epam.task1_3.repository.comparator.sortByCoordinate;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;

import java.util.Comparator;

public class SortByPointYCoordinateX implements Comparator<Oval> {

    @Override
    public int compare(Oval o1, Oval o2) {
        if (o1 == null || o2 == null) {
            throw new IllegalArgumentException("Error. Oval can't be null");
        }

        Point pointYOval1 = o1.getPointY();
        Point pointYOval2 = o2.getPointY();

        double coordinateXPointYOval1 = pointYOval1.getX();
        double coordinateXPointYOval2 = pointYOval2.getX();

        return coordinateXPointYOval1 < coordinateXPointYOval2 ? -1 : coordinateXPointYOval1 == coordinateXPointYOval2 ? 0 : 1;
    }
}
