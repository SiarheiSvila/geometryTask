package com.epam.task1_3.repository.comparator.sortByCoordinate;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;

import java.util.Comparator;

public class SortByPointYCoordinateY implements Comparator<Oval> {

    @Override
    public int compare(Oval o1, Oval o2) {
        if (o1 == null || o2 == null) {
            throw new IllegalArgumentException("Error. Oval can't be null");
        }

        Point pointYOval1 = o1.getPointY();
        Point pointYOval2 = o2.getPointY();

        double coordinateYPointYOval1 = pointYOval1.getY();
        double coordinateYPointYOval2 = pointYOval2.getY();

        return coordinateYPointYOval1 < coordinateYPointYOval2 ? -1 : coordinateYPointYOval1 == coordinateYPointYOval2 ? 0 : 1;
    }
}
