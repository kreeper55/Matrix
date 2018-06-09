package collections;


import org.junit.Test;

import java.text.ParseException;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class ListDemoTest {

    @Test
    public void testAmountByFirstChar() {
        List<String> testList = new ArrayList<>();
        testList.add("kek");
        testList.add("sas");
        testList.add("sad");
        testList.add("kkk");
        assertEquals(2, ListDemo.quantityStrStartingSymbol(testList, 's'));
    }

    @Test
    public void testGetNamesakes() throws ParseException {
        List<Human> list = new ArrayList<>();
        Human human1 = new Human("Viktor", "Ivanov", "Petrovich", 19);
        Human human2 = new Human("Vasiliy", "Pupkin", "Nikolaevich", 31);
        Human human3 = new Human("Leonid", "Pupkin", "Vladimirovich", 20);
        list.add(human1);
        list.add(human2);
        list.add(human3);
        assertEquals(2, ListDemo.findSurnameSake(list, human2).size());
    }

    @Test
    public void testRemovePerson() throws ParseException {
        List<Human> list = new ArrayList<>();
        Human human = new Human("Viktor", "Ivanov", "Petrovich", 19);
        Human human2 = new Human("Vasiliy", "Pupkin", "Nikolaevich", 31);
        Human human3 = new Human("Leonid", "Pupkin", "Vladimirovich", 19);
        list.add(human);
        list.add(human3);
        list.add(human2);
        List<Human> newList = ListDemo.removeHuman(list, human2);
        list.removeAll(newList);
        assertEquals(1, list.size());
        assertEquals(human2, list.get(0));
    }

    @Test
    public void noInputIntersections() {
        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(1);
        set2.add(2);
        set2.add(4);
        list.add(set1);
        list.add(set2);
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(50);
        set.add(7);
        assertEquals(1, ListDemo.withoutIntersection(list, set).size());
        assertEquals(set2, ListDemo.withoutIntersection(list, set).get(0));
    }

    @Test
    public void testGetPeopleById() throws ParseException {
        Map<Integer, Human> map = new HashMap<>();
        Human a = new Human("A", "B", "C", 28);
        Human b = new Human("A", "B", "D", 23);
        Human c = new Human("A", "B", "E", 20);
        map.put(1, a);
        map.put(2, b);
        map.put(3, c);
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(1);
        Set<Human> checkSet = new HashSet<>();
        checkSet.add(a);
        checkSet.add(c);
        assertEquals(checkSet, ListDemo.getPeopleById(map, set));
    }

    @Test
    public void testGet18Years() throws ParseException {
        Map<Integer, Human> map = new HashMap<>();
        Human a = new Human("A", "B", "C", 42);
        Human b = new Human("A", "B", "D", 25);
        Human c = new Human("A", "B", "E", 17);
        map.put(1, a);
        map.put(2, b);
        map.put(3, c);
        List<Integer> check = new ArrayList<>();
        check.add(1);
        check.add(2);
        assertEquals(check, ListDemo.humansOver18(map));
    }


}