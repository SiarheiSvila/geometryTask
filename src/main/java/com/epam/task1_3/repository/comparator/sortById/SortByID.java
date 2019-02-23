package com.epam.task1_3.repository.comparator.sortById;

import com.epam.task1_3.entity.Oval;

import java.util.Comparator;

public class SortByID implements Comparator<Oval> {

    @Override
    public int compare(Oval o1, Oval o2) {
        if (o1 == null || o2 == null) {
            throw new IllegalArgumentException("Error. Oval can't be null");
        }

        Integer oval1Id = o1.getId();
        Integer oval2Id = o2.getId();

        return oval1Id < oval2Id ? -1 : oval1Id == oval2Id ? 0 : 1;
    }
}
