package next.ch03;

import java.util.function.Function;

/**
 * Created by Shotaro.S on 2016/02/01.
 */
@FunctionalInterface
public interface TriFunction<S, T, U, R> {
        R apply(S s, T t, U u);
}
