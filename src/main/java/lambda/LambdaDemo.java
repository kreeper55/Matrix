package lambda;

import java.util.List;
import java.util.function.Function;
//import java.util.arr
import java.util.function.BiPredicate;

public class LambdaDemo {
    public static final Function<String, Integer> getLength = String::length;
    public static final Function<String, Character> getSymb = str -> str.length() == 0 ? null : str.charAt(0);
//    public static final Function<String, Boolean> hasSpace = str -> str.contains(" ") ? true : false;
//    public static final Predicate<String> hasSpace = str -> str.contains(' ');
//    public static final Predicate<String> hasSpace = str -> str.indexOf(' ') < 0;
    public static final Function<String, Boolean> hasSpace = str -> str.indexOf(' ') < 0;
    public static final Function<String, Integer> countWords = str -> {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                count++;
            }
        }
        return count + 1;
    };
    public static final Function<Human, Integer> getAge = Human::getAge;//human -> human.getAge();
    public static final BiPredicate<Human, Human> sameLastName = (human1, human2) -> human1.getLastName().equals(human2.getLastName());
    public static final Function<Human, String> getFullName = human -> human.getFirstName() + " " + human.getLastName() + " " + human.getMiddleName();
    public static final Function<Human, Human> overAge = h -> new Human(h.getFirstName(), h.getLastName(), h.getMiddleName(), h.getAge() + 1, h.getSex());
    public static final BiPredicate<List<Human>, Integer> isYoungerMaxAge = (list , maxAge) -> {
        for (Human human : list) {
            if(human.getAge() > maxAge) return false;
        }
        return true;
    };

//    public static final Function<Student, Integer> getAgeStudent = Student::getAge;
//    public static final Function<Student, String> getFullNameStudent = student -> student.getFirstName() + " " + student.getLastName() + " " + student.getMiddleName();

}
