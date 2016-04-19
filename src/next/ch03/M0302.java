package next.ch03;

import next.Z;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Created by Shotaro.S on 2016/02/01.
 */
public class M0302 {
    // 関数型インタフェース
    // Function<T, R> ----- R apply(T t)
    // Consumer<T>    ----- void accept(T t)
    // Supplier<T>    ----- T get()
    // Predicate<T>   ----- boolean test(T t)

    // UnaryOperator<T>   ----- T apply(T t)
    // BinaryOperator<T>  ----- T apply(T t1, T t2)

    // インタフェース
    // ・デフォルトメソッド
    // ・staticメソッド

    public static void main(String... args){
        Comparator<Integer> comparator = (Integer x, Integer y) -> Integer.compare(x, y);
        Z.p(comparator.compare(3, 4));

        Function<Integer, String> f = i -> String.valueOf(i*10);
        Z.p(f.apply(3));
    }
}
