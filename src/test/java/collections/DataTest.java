package collections;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DataTest {
    @Test
    public void testGetAll() {
        Data data = new Data("A",     new Group(101, 1, 4, 7),
                                            new Group(102, 2, 3, 5, 6),
                                            new Group(103, 11, 4));
        List<Integer> check = new ArrayList<>();
        check.add(1);
        check.add(4);
        check.add(7);
        check.add(2);
        check.add(3);
        check.add(5);
        check.add(6);
        check.add(11);
        check.add(4);
        assertEquals(check, DataDemo.getAll(data));
    }

    @Test
    public void testGetAll2() {
        Data data = new Data("B");
        List<Integer> check = new ArrayList<>();
        assertEquals(check, DataDemo.getAll(data));
    }

    @Test
    public void getSetName() {
        Data data = new Data("C", new Group(1, 2));
        data.setName("CIA");
        assertEquals("CIA", data.getName());
    }

    @Test
    public void setGroups() {
        Group[] g = {new Group(2, 3,4), new Group(1,1)};
        Data data = new Data("D");
        data.setGroups(g);
        assertEquals(g.length, data.length());
    }
}