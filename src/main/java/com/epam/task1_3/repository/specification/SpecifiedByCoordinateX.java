package com.epam.task1_3.repository.specification;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;
import com.epam.task1_3.repository.specification.api.Specification;

public class SpecifiedByCoordinateX implements Specification {

    private double coordinateX;

    public SpecifiedByCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    @Override
    public boolean isSpecified(Oval oval) {
        if (oval == null) {
            throw new IllegalArgumentException("Error. Oval is null");
        }

        Point pointX = oval.getPointX();
        Point pointY = oval.getPointY();

        return coordinateX == pointX.getX() ||
                coordinateX == pointY.getX();
    }
}
