package com.epam.task1_3.repository.api;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.repository.specification.api.Specification;

import java.util.List;

public interface Repository {
    void add(Oval oval);

    void add(Iterable<Oval> ovals);

    void remove(Oval oval);

    void remove(Specification specification);

    void update(Oval newOval);

    List<Oval> query(Specification specification);
}
