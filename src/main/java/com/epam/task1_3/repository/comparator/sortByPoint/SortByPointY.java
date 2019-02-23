package com.epam.task1_3.repository.comparator.sortByPoint;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;

import java.util.Comparator;

public class SortByPointY implements Comparator<Oval> {

    @Override
    public int compare(Oval o1, Oval o2) {
        if (o1 == null || o2 == null) {
            throw new IllegalArgumentException("Error. Oval can't be null");
        }

        Point pointYOval1 = o1.getPointY();
        Point pointYOval2 = o2.getPointY();

        int hashOfPointYOval1 = pointYOval1.hashCode();
        int hashOfPointYOval2 = pointYOval2.hashCode();

        return hashOfPointYOval1 < hashOfPointYOval2 ? -1 : hashOfPointYOval1 == hashOfPointYOval2 ? 0 : 1;
    }
}
