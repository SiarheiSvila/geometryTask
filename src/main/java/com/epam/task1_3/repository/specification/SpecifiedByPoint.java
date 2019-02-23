package com.epam.task1_3.repository.specification;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;
import com.epam.task1_3.repository.specification.api.Specification;

public class SpecifiedByPoint implements Specification {
    private Point point;

    public SpecifiedByPoint(Point point) {
        setPoint(point);
    }

    private void setPoint(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("Error. Point can't be null");
        }
        this.point = point;
    }

    @Override
    public boolean isSpecified(Oval oval) {
        if (oval == null) {
            throw new IllegalArgumentException("not allow for the quadrilateral to be null");
        }
        return point.equals(oval.getPointX()) ||
                point.equals(oval.getPointY());
    }
}
