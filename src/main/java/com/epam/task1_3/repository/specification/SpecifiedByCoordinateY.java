package com.epam.task1_3.repository.specification;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;
import com.epam.task1_3.repository.specification.api.Specification;

public class SpecifiedByCoordinateY implements Specification {

    private double coordinateY;

    public SpecifiedByCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public boolean isSpecified(Oval oval) {
        if (oval == null) {
            throw new IllegalArgumentException("Error. Oval is null");
        }

        Point pointX = oval.getPointX();
        Point pointY = oval.getPointY();

        return coordinateY == pointX.getY() ||
                coordinateY == pointY.getY();
    }
}
