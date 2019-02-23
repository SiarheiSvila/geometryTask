package com.epam.task1_3.repository;

import com.epam.task1_3.entity.Oval;
import com.epam.task1_3.entity.Point;
import com.epam.task1_3.repository.comparator.sortByCoordinate.SortByPointYCoordinateX;
import com.epam.task1_3.repository.comparator.sortById.SortByID;
import com.epam.task1_3.repository.comparator.sortByPoint.SortByPointX;
import com.epam.task1_3.repository.specification.SpecifiedByCoordinateX;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositoryTest {

    private final static Oval OVAL_1 = new Oval(12, new Point(1, 2), new Point(3, 1));
    private final static Oval OVAL_2 = new Oval(57, new Point(2, -3), new Point(0, 3.4));

    private final static Oval OVAL_FOR_UPDATING = new Oval(57, new Point(3.6, -1), new Point(0.4, 4));

    private final static Oval OVAL_FOR_QUERY_1 = new Oval(1, new Point(0, -1), new Point(0.4, 4));
    private final static Oval OVAL_FOR_QUERY_2 = new Oval(2, new Point(1, 2), new Point(0, 5));
    private final static Oval OVAL_FOR_QUERY_3 = new Oval(3, new Point(0, -1), new Point(0, 4));
    private final static Oval OVAL_FOR_QUERY_4 = new Oval(4, new Point(7, -1), new Point(-3, 4));
    private final static Oval OVAL_FOR_QUERY_5 = new Oval(5, new Point(0.002, -1), new Point(-0.5, 4));

    private final static List<Oval> OVAL_LIST_FULL = Arrays.asList(OVAL_1, OVAL_2);
    private final static List<Oval> OVAL_LIST_CONTAINS_FIRST_ELEMENT = Arrays.asList(OVAL_1);
    private final static List<Oval> OVAL_LIST_CONTAINS_SECOND_ELEMENT = Arrays.asList(OVAL_2);

    private final static List<Oval> OVAL_LIST_FULL_SORTED_BY_ID = Arrays.asList(OVAL_1, OVAL_2);
    private final static List<Oval> OVAL_LIST_FULL_SORTED_BY_POINT_X = Arrays.asList(OVAL_2, OVAL_1);
    private final static List<Oval> OVAL_LIST_FULL_SORTED_BY_POINT_Y_COORDINATE_X = Arrays.asList(OVAL_2, OVAL_1);

    private final static List<Oval> OVAL_LIST_FULL_AFTER_UPDATING = Arrays.asList(OVAL_1, OVAL_FOR_UPDATING);

    private final static List<Oval> OVAL_LIST_FOR_QUERY_ORIGINAL = Arrays.asList(OVAL_FOR_QUERY_1,
            OVAL_FOR_QUERY_2,
            OVAL_FOR_QUERY_3,
            OVAL_FOR_QUERY_4,
            OVAL_FOR_QUERY_5);
    private final static List<Oval> OVAL_LIST_FOR_QUERY_CHANGED = Arrays.asList(OVAL_FOR_QUERY_1, OVAL_FOR_QUERY_2, OVAL_FOR_QUERY_3);

    private static OvalRepository repository;

    @Test
    public void addOneElement() {
        //given
        repository = OvalRepository.getInstance(new ArrayList<>());

        //when
        repository.add(OVAL_1);

        //then
        List<Oval> actual = repository.getOvalList();
        Assert.assertEquals(OVAL_LIST_CONTAINS_FIRST_ELEMENT, actual);
    }

    @Test
    public void addList() {
        //given
        repository = OvalRepository.getInstance(new ArrayList<>());

        //when
        repository.add(OVAL_LIST_FULL);

        //then
        List<Oval> actual = repository.getOvalList();
        Assert.assertEquals(OVAL_LIST_FULL, actual);
    }

    @Test
    public void sortById() {
        //given
        repository = OvalRepository.getInstance(OVAL_LIST_FULL);

        //when
        repository.sort(new SortByID());

        //then
        List<Oval> actual = repository.getOvalList();
        Assert.assertEquals(OVAL_LIST_FULL_SORTED_BY_ID, actual);
    }

    @Test
    public void sortByPointX() {
        //given
        repository = OvalRepository.getInstance(OVAL_LIST_FULL);

        //when
        repository.sort(new SortByPointX());

        //then
        List<Oval> actual = repository.getOvalList();
        Assert.assertEquals(OVAL_LIST_FULL_SORTED_BY_POINT_X, actual);
    }

    @Test
    public void sortByPointYCoordinateX() {
        //given
        repository = OvalRepository.getInstance(OVAL_LIST_FULL);

        //when
        repository.sort(new SortByPointYCoordinateX());

        //then
        List<Oval> actual = repository.getOvalList();
        Assert.assertEquals(OVAL_LIST_FULL_SORTED_BY_POINT_Y_COORDINATE_X, actual);
    }

    @Test
    public void removeFirstElement() {
        //given
        repository = OvalRepository.getInstance(new ArrayList<>());
        repository.add(OVAL_LIST_FULL);

        //when
        repository.remove(OVAL_1);

        //then
        List<Oval> actual = repository.getOvalList();
        Assert.assertEquals(OVAL_LIST_CONTAINS_SECOND_ELEMENT, actual);
    }

    @Test
    public void removeFirstElementBySpecification() {
        //given
        repository = OvalRepository.getInstance(new ArrayList<>());
        repository.add(OVAL_LIST_FULL);

        //when
        repository.remove(new SpecifiedByCoordinateX(3));

        //then
        List<Oval> actual = repository.getOvalList();
        Assert.assertEquals(OVAL_LIST_CONTAINS_SECOND_ELEMENT, actual);
    }

    @Test
    public void updateSecondElement() {
        //given
        repository = OvalRepository.getInstance(new ArrayList<>());
        repository.add(OVAL_LIST_FULL);

        //when
        repository.update(OVAL_FOR_UPDATING);

        //then
        List<Oval> actual = repository.getOvalList();
        Assert.assertEquals(OVAL_LIST_FULL_AFTER_UPDATING, actual);
    }

    @Test
    public void queryOvalsWithXCoordinateEqualsZero() {
        //given
        repository = OvalRepository.getInstance(new ArrayList<>());
        repository.add(OVAL_LIST_FOR_QUERY_ORIGINAL);

        //when
        List<Oval> actual = repository.query(new SpecifiedByCoordinateX(0));

        //then
        Assert.assertEquals(OVAL_LIST_FOR_QUERY_CHANGED, actual);
    }
}
