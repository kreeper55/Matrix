package lambda;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaRunner {
    public static <T, R> R run(Function<T, R> f, T t) {
        return f.apply(t);
    }

    public static <U, V> boolean run(BiPredicate<U, V> f, U u, V v) {
        return f.test(u, v);
    }
}
