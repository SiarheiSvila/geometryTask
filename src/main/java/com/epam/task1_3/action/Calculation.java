package com.epam.task1_3.action;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;
import org.apache.log4j.Logger;

public class Calculation {

    final private static Logger LOGGER = Logger.getLogger(Calculation.class);

    public double getArea(Oval oval) {
        if (oval == null) {
            LOGGER.error("Oval is not found");
            throw new IllegalArgumentException("Error in area calculation");
        }

        double lengthX = getLengthX(oval);
        double lengthY = getLengthY(oval);

        return Math.PI * lengthX * lengthY;
    }

    public double getPerimeter(Oval oval) {
        if (oval == null) {
            LOGGER.error("Oval is not found");
            throw new IllegalArgumentException("Error in perimeter calculation");
        }

        double lengthX = getLengthX(oval);
        double lengthY = getLengthY(oval);

        return Math.PI * 2 * Math.sqrt((lengthX * lengthX + lengthY * lengthY) / 2);
    }

    private Point getCenter(Oval oval) {
        Point pointX = oval.getPointX();
        Point pointY = oval.getPointY();
        Point center = new Point(pointY.getX(), pointX.getY());

        return center;
    }

    private double getLengthX(Oval oval) {
        Point center = getCenter(oval);

        Point pointX = oval.getPointX();
        return Math.abs(pointX.getX() - center.getX());

    }

    private double getLengthY(Oval oval) {
        Point center = getCenter(oval);

        Point pointY = oval.getPointY();
        return Math.abs(pointY.getY() - center.getY());
    }

    public boolean isCircle(Oval oval) {
        if (oval == null) {
            LOGGER.error("Oval is not found");
            throw new IllegalArgumentException("Error in isCircle method");
        }

        return (getLengthX(oval) == getLengthY(oval));
    }

    public boolean isOxCrossed(Oval oval) {
        if (oval == null) {
            LOGGER.error("Oval is not found");
            throw new IllegalArgumentException("Error in isOxCrossed method");
        }

        Point pointY = oval.getPointY();
        Point pointX = oval.getPointX();

        Point oppositeToPointY = new Point(pointY.getX(), pointY.getY() - 2 * getLengthY(oval));

        if (pointY.getY() < pointX.getY()) {
            oppositeToPointY = new Point(pointY.getX(), pointY.getY() + 2 * getLengthY(oval));
        }

        if (pointY.getY() == 0 || oppositeToPointY.getY() == 0) {
            return true;
        } else {
            return (pointY.getY() / oppositeToPointY.getY()) < 0;
        }
    }

    public boolean isOyCrossed(Oval oval) {
        if (oval == null) {
            LOGGER.error("Oval is not found");
            throw new IllegalArgumentException("Error in isOCyrossed method");
        }

        Point pointX = oval.getPointX();
        Point pointY = oval.getPointY();

        Point oppositeToPointX = new Point(pointX.getX() - 2 * getLengthX(oval), pointX.getY());

        if (pointX.getX() < pointY.getX()) {
            oppositeToPointX = new Point(pointX.getX() + 2 * getLengthX(oval), pointX.getY());
        }

        if (pointX.getX() == 0 || oppositeToPointX.getX() == 0) {
            return true;
        } else {
            return (pointX.getX() / oppositeToPointX.getX()) < 0;
        }
    }

}
