package lambda;

import lambda.Human;
import lambda.Student;
import lambda.LambdaDemo;
import lambda.LambdaRunner;
import java.util.ArrayList;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LambdaRunnerTest {

    private static final Human h0 = new Human("Sanya", "Golovanov", "pshh", 22, Human.Sex.MALE); // for test age
    private static final Human h1 = new Human("Sanya", "Golovanov", "pshh", 23, Human.Sex.MALE);
    private static final Human h2 = new Human("Slava", "Ustugov", "hhhh", 20, Human.Sex.MALE);
    private static final Human h3 = new Human("Iliya", "Tupoy", "llll", 18, Human.Sex.MALE);

    private static final Student s1 = new Student("Max", "Maxutov", "kkkk", 19, Human.Sex.MALE,
            "OmGU", "Physical faculty ", "applied physics");
    private static final Student s2 = new Student("Tanya", "Golovanov", "bbbb", 21, Human.Sex.FEMALE,
            "OmGU", "IMIT", "pogromist");



    @Test
    public void FunctionTest() {
        assertEquals(Integer.valueOf(5), LambdaRunner.run(LambdaDemo.getLength, "SLAVA"));
        assertEquals(Character.valueOf('T'), LambdaRunner.run(LambdaDemo.getSymb, "Tupoy"));
        assertEquals(Integer.valueOf(10), LambdaRunner.run(LambdaDemo.countWords, "qwert,, , 123, 123, 2,,7,,"));
        assertEquals(Integer.valueOf(7), LambdaRunner.run(LambdaDemo.countWords, "каждый, охотник, желает, знать, где, сидит, фазан"));

        assertEquals(Integer.valueOf(19), LambdaRunner.run(LambdaDemo.getAge, s1));
        assertEquals(Integer.valueOf(21), LambdaRunner.run(LambdaDemo.getAge, s2));
        assertEquals(Integer.valueOf(20), LambdaRunner.run(LambdaDemo.getAge, h2));

        assertEquals("Max Maxutov kkkk", LambdaRunner.run(LambdaDemo.getFullName, s1));
        assertEquals("Iliya Tupoy llll", LambdaRunner.run(LambdaDemo.getFullName, h3));

        assertEquals(h1, LambdaRunner.run(LambdaDemo.overAge, h0));


        assertTrue(LambdaRunner.run(LambdaDemo.hasSpace, "IMIT"));
        assertFalse(LambdaRunner.run(LambdaDemo.hasSpace, "Mathe ma tic"));
    }

    @Test
    public void BiPredicateTest() {
        assertTrue(LambdaRunner.run(LambdaDemo.sameLastName, h1, s2));
        assertFalse(LambdaRunner.run(LambdaDemo.sameLastName, h1, h3));

        List<Human> list1 = new ArrayList<>(3);
        List<Human> list2 = new ArrayList<>(3);
        list1.add(h1); list1.add(s1); list1.add(h3);
        list2.add(s1); list2.add(s2); list2.add(h2);
        assertTrue(LambdaRunner.run(LambdaDemo.isYoungerMaxAge, list1, 24));
        assertFalse(LambdaRunner.run(LambdaDemo.isYoungerMaxAge, list2,  20));
    }
}