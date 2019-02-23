package com.epam.task1_3.entity;

public class OvalParameters {
    private final double area;
    private final double perimeter;

    public OvalParameters(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }
}
