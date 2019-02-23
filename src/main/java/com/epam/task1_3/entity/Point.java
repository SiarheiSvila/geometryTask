package com.epam.task1_3.entity;

public class Point {

    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;


        Point point = (Point) o;
        if (x != point.x) return false;
        if (y != point.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (31 * x + 263 * y + 812);
    }
}
