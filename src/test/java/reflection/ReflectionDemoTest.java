package reflection;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import collections.Human;
import collections.Data;
import collections.Group;
import collections.Student;

public class ReflectionDemoTest {
    @Test
    public void countIsHuman() throws Exception {
        List<Object> list = new ArrayList<>();
        list.add(new Student("Sanya", "Golovanov", "hhhh", 22));
        list.add(new Human("Max", "Maxutov", "kkk", 19));
        list.add(new Human("Slava", "Ustugov", "ccc", 20));
        list.add(new Data("abc", new Group(1,2, 3)));
        assertEquals(3, ReflectionDemo.countIsHuman(list));
    }

    @Test
    public void getNamePublicMethods() throws Exception {
        Human human = new Human("A", "B", "C", 19);
        Student student = new Student("Bob", "Charli", "Alpha", 23);
        //System.out.println(ReflectionDemo.getNamePublicMethods(human).toString());
        assertEquals(17, ReflectionDemo.getNamePublicMethods(human).size());
        assertEquals(17, ReflectionDemo.getNamePublicMethods(student).size());
    }

    @Test
    public void getAllSuperClass() throws Exception {
        Student s = new Student("E","D","meow",25);
        List<String> list = new ArrayList<>(2);
        list.add("collections.Human");
        list.add("java.lang.Object");
        assertEquals(list, ReflectionDemo.getAllSuperClass(s));
    }

    @Test
    public void testExecuteList() throws Exception {
        IExecutable executable = () -> System.out.println("EXECUTED!");
        List<Object> list = new ArrayList<>();
        list.add(executable);
        list.add(new TestClassForExecute());
        list.add(new Student("Sanya", "Golovanov", "hhhh", 22));
        assertEquals(2, ReflectionDemo.executeList(list));
    }

    @Test
    public void testGetGettersAndSetter() {
        Human human = new Human("Max", "Maxutov", "kkk", 19);
        List<String> nameMethods = new ArrayList<>();
        nameMethods.add("setFirstName");
        nameMethods.add("setLastName");
        nameMethods.add("setMiddleName");
        nameMethods.add("setAge");
        nameMethods.add("getFirstName");
        nameMethods.add("getLastName");
        nameMethods.add("getMiddleName");
        nameMethods.add("getAge");

        List<String> expected = nameMethods.stream().sorted().collect(Collectors.toList());
        List<String> actual = ReflectionDemo.getGettersAndSetters(human).stream().sorted().collect(Collectors.toList());
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

}