package next.ch03;

import next.Z;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/**
 * Created by Shotaro.S on 2016/02/01.
 */
public class M0306 {
    // メソッド参照
    // tests.forEach(text -> System.out.println(text));
    // ↑をラムダ式使わず表現したい↓
    // texts.forEach(System.out::println);

    // ・クラスメソッド参照
    // ・インスタンスメソッド参照
    // ・コンストラクタ参照

    public static void print(String text){
        Z.p(text);
    }

    // Function<T, R> ----- R apply(T t)
    // Consumer<T>    ----- void accept(T t)
    // Supplier<T>    ----- T get()
    // Predicate<T>   ----- boolean test(T t)

    // UnaryOperator<T>  ----- T apply(T t)
    // BinaryOperator<T> ----- T apply(T t1, T t2)

    public static void main(String... args){
        // ラムダ式
        Consumer<String> consumer1 = text -> M0306.print(text);
        consumer1.accept("ラムダ！");

        // メソッド参照
        // ・クラスメソッド参照
        Consumer<String> consumer2 = M0306::print;
        consumer2.accept("メソッド参照！");

        // ・コンストラクタ参照
        Supplier<Random> supplier1 = () -> new Random();
        Random r1 = supplier1.get();
        Z.p(r1.nextInt());

        Supplier<Random> supplier2 = Random::new;
        Random r2 = supplier2.get();
        Z.p(r2.nextInt());

        // 配列の事例
        // ラムダ式
        IntFunction<String[]> ifunc = (int size) -> new String[size];
        String[] s1 = ifunc.apply(10);
        s1[0] = "[0]Taro";
        s1[1] = "[1]Jiro";
        Z.p(s1);

        Z.l();

        // コンストラクタ参照
        IntFunction<String[]> ifunc2 = String[]::new;
        String[] s2 = ifunc2.apply(5);
        s2[3] = "[3]PHP";
        Z.p(s2);
    }
}
