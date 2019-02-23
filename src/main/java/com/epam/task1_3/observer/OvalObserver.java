package com.epam.task1_3.observer;

import com.epam.task1_3.action.Calculation;
import com.epam.task1_3.entity.OvalParameters;
import com.epam.task1_3.observer.api.Observer;

import java.util.HashMap;
import java.util.Map;

public class OvalObserver implements Observer<OvalObservable> {

    private final Calculation calculation;
    private static OvalObserver instance;

    private Map<Integer, OvalParameters> ovalParametersMap = new HashMap<>();

    private OvalObserver(Calculation calculation) {
        this.calculation = calculation;
    }

    public static OvalObserver getInstance(Calculation calculation) {
        if (instance == null) {
            instance = new OvalObserver(calculation);
        }
        return instance;
    }

    @Override
    public void update(OvalObservable item) {
        double area = calculation.getArea(item);
        double perimeter = calculation.getPerimeter(item);

        OvalParameters parameters = new OvalParameters(area, perimeter);

        ovalParametersMap.put(item.getId(), parameters);
    }

    public OvalParameters getParameters(Integer id) {
        return ovalParametersMap.get(id);
    }
}
