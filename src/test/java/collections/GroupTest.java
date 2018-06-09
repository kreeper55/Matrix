package collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupTest {
    @Test
    public void testGetSetId(){
        Group g = new Group(3, 1, 5);
        assertEquals(3, g.getId());
        g.setId(78);
        assertEquals(78, g.getId());
    }

    @Test
    public void testSetData() {
        Group g = new Group(3, 1, 5);
        int[] d = {2,3,4,3};
        g.setData(d);
        assertEquals(d, g.getData());
    }

}