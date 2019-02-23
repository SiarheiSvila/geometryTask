package com.epam.task1_3.entity;

public class Oval {

    private Point pointX;
    private Point pointY;

    private final Integer id;

    public Oval(Integer id, Point pointX, Point pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
        this.id = id;
    }

    public void setPointX(Point pointX) {
        this.pointX = pointX;
    }

    public void setPointY(Point pointY) {
        this.pointY = pointY;
    }

    public Point getPointX() {
        return pointX;
    }

    public Integer getId() {
        return id;
    }

    public Point getPointY() {

        return pointY;
    }

    @Override
    public String toString() {
        return "Oval{" +
                "pointX=" + pointX +
                ", pointY=" + pointY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Oval oval = (Oval) o;

        if (!pointX.equals(oval.pointX)) return false;
        if (!pointY.equals(oval.pointY)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (2412 + 35 * pointX.hashCode() + 96 * pointY.hashCode());
    }
}
