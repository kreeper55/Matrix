package collections;

import java.util.*;

public class DataDemo {
    public static List<Integer> getAll(Data data) {
        DataIterator iterator = data.iterator();
        List<Integer> list = new ArrayList<>();
        while(iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
