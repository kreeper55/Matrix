package collections;

import java.util.stream.Collectors;
import java.util.*;

public class ListDemo {

    public static int quantityStrStartingSymbol(List<String> strings, char symbol) {
        int count = 0;
        for (String line : strings)
            if (line.startsWith(String.valueOf(symbol)))
                count++;
        return count;
    }

    public static List<Human> findSurnameSake(List<Human> humans, Human other) {
        List<Human> surnamesake = new ArrayList<>();
        for (Human human : humans)
            if (human.getLastName().equals(other.getLastName()))
                surnamesake.add(human);
        return surnamesake;
    }

    public static List<Human> removeHuman(List<Human> humans, Human other) {
        List<Human> withoutOther = new ArrayList<>(humans);
        while(withoutOther.remove(other)){};
        return withoutOther;
    }

    public static List<Set<Integer>> withoutIntersection(List<Set<Integer>> sets, Set<Integer> other) {
        List<Set<Integer>> list = new ArrayList<>();
        boolean flag;
        for (Set<Integer> set : sets) {
            flag = true;
            for (Integer integer : set)
                if (other.contains(integer)) {
                    flag = false;
                    break;
                }
            if (flag)
                list.add(set);
        }
        return list;
    }


    public static Set<Human> getPeopleById (Map<Integer, Human> mapHumans, Set<Integer> id) {
        Set<Human> people = new HashSet<>();
        for (Integer i : id) {
            Human human = mapHumans.get(i);
            if (human != null) people.add(human);
        }
        return people;
    }

    public static List<Integer> humansOver18 (Map<Integer, Human> map) {
        Set<Integer> keys = map.keySet();
        List<Integer> answer = new ArrayList<>();
        for (int i : keys) {
            if (map.get(i) != null && map.get(i).getAge() >= 18) {
                answer.add(i);
            }
        }
        return answer;
    }



}


