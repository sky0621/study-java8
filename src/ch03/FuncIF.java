package ch03;

/**
 * Created by Shotaro.S on 2015/12/29.
 */
@FunctionalInterface
public interface FuncIF<S, T, U, R> {

    public R testen(S s, T t, U u);

}
