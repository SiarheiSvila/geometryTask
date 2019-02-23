package com.epam.task1_3.observer.api;

import com.epam.task1_3.entity.Oval;

public interface Observable<T extends Oval> {
    void addObsever(Observer<T> observer);
}
