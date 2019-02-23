package com.epam.task1_3.repository.comparator.sortByPoint;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;

import java.util.Comparator;

public class SortByPointX implements Comparator<Oval> {

    @Override
    public int compare(Oval o1, Oval o2) {
        if (o1 == null || o2 == null) {
            throw new IllegalArgumentException("Error. Oval can't be null");
        }

        Point pointXOval1 = o1.getPointX();
        Point pointXOval2 = o2.getPointX();

        int hashOfPointXOval1 = pointXOval1.hashCode();
        int hashOfPointXOval2 = pointXOval2.hashCode();

        return hashOfPointXOval1 < hashOfPointXOval2 ? -1 : hashOfPointXOval1 == hashOfPointXOval2 ? 0 : 1;
    }
}
