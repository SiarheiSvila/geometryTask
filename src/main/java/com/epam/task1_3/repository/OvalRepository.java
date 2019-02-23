package com.epam.task1_3.repository;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.repository.api.OvalSort;
import com.epam.task1_3.repository.api.Repository;
import com.epam.task1_3.repository.specification.api.Specification;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OvalRepository implements Repository, OvalSort {

    private static OvalRepository instance;

    private List<Oval> ovalList;

    final private static Logger LOGGER = Logger.getLogger(OvalRepository.class);

    private OvalRepository(List<Oval> ovalList) {
        this.ovalList = ovalList;
    }

    public static OvalRepository getInstance(List<Oval> ovalList) {
        if (instance == null) {
            instance = new OvalRepository(ovalList);
        }

        return instance;
    }

    public List<Oval> getOvalList() {
        return ovalList;
    }

    @Override
    public void sort(Comparator comparator) {
        if (comparator == null) {
            LOGGER.error("Comparator can't be null");
            throw new IllegalArgumentException("Error in sort");
        }

        ovalList.sort(comparator);
    }

    @Override
    public void add(Oval oval) {
        if (oval == null) {
            LOGGER.error("Oval can't be null");
            throw new IllegalArgumentException("Error in adding an oval");
        }

        ovalList.add(oval);
    }

    @Override
    public void add(Iterable<Oval> ovals) {
        if (ovals == null) {
            LOGGER.error("Iterable<Oval> can't be null");
            throw new IllegalArgumentException("Error in adding Iterable<Oval>");
        }

        for (Oval oval : ovals) {
            if (!ovalList.contains(oval)) {
                ovalList.add(oval);
            }
        }
    }

    @Override
    public void remove(Oval oval) {
        if (oval == null) {
            LOGGER.error("Oval can't be null");
            throw new IllegalArgumentException("Error in removing an oval");
        }

        ovalList.remove(oval);
    }

    @Override
    public void remove(Specification specification) {
        if (specification == null) {
            LOGGER.error("Specification can't be null");
            throw new IllegalArgumentException("Error in removing by specification");
        }

        if (!ovalList.isEmpty()) {
            for (Oval oval : ovalList) {
                if (specification.isSpecified(oval)) {
                    ovalList.remove(oval);
                }
            }
        }
    }

    @Override
    public void update(Oval newOval) {
        if (newOval == null) {
            LOGGER.error("Oval can't be null");
            throw new IllegalArgumentException("Error in updating");
        }

        Integer newOvalId = newOval.getId();

        int index = -1;

        for (Oval oval : ovalList) {
            Integer oldOvalId = oval.getId();
            if (oldOvalId.equals(newOvalId)) {
                index = ovalList.indexOf(oval);
                break;
            }
        }

        if (index != -1) {
            ovalList.set(index, newOval);
        }

    }

    @Override
    public List<Oval> query(Specification specification) {
        if (specification == null) {
            LOGGER.error("Specification is null");
            throw new IllegalArgumentException("Error in query");
        }

        List<Oval> specifiedList = new ArrayList<>();

        if (!ovalList.isEmpty()) {
            for (Oval o : ovalList) {
                if (specification.isSpecified(o)) {
                    specifiedList.add(o);
                }
            }
        }


        return specifiedList;
    }
}
