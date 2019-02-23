package com.epam.task1_3.observer.api;

import com.epam.task1_3.entity.Oval;

public interface Observer<T extends Oval> {
    void update(T item);
}
