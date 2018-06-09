package collections;


import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;


public class HumanTest {
    @Test
    public void testSetters() throws ParseException {
        Human human = new Human("Vasiliy", "Pupkin", "Nikolaevich", 21);
        human.setFirstName("A");
        human.setLastName("B");
        human.setMiddleName("C");
        Human h = new Human("A", "B", "C", 21);
        assertEquals(h, human);
    }
}