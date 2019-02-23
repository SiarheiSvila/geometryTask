package com.epam.task1_3.observer;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;
import com.epam.task1_3.observer.api.Observable;
import com.epam.task1_3.observer.api.Observer;

import java.util.ArrayList;
import java.util.List;

public class OvalObservable extends Oval implements Observable<Oval> {

    private List<Observer<Oval>> observers = new ArrayList<Observer<Oval>>();


    public OvalObservable(Integer id, Point pointX, Point pointY) {
        super(id, pointX, pointY);
    }

    @Override
    public void setPointX(Point pointX) {
        super.setPointX(pointX);
        notifyObservers();
    }

    @Override
    public void setPointY(Point pointY) {
        super.setPointY(pointY);
        notifyObservers();
    }

    public void addObsever(Observer<Oval> observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
