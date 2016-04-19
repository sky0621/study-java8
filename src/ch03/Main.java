package ch03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntUnaryOperator;

import static java.lang.Integer.compare;

/**
 * Created by Shotaro.S on 2015/12/28.
 */
public class Main {

    // ラムダ式＝関数型インタフェースに限定
    // 実装すべきメソッドが１つであるインタフェース

    // java.util.Function
    // Function<T, R> ... R apply(T t) ... 引数うけとって返り値があるメソッドを定義
    //    IntFunction
    // Consumer<T> ... void accept(T t) ... 引数はあるが返り値がvoidであるメソッドを定義
    //    DoubleConsumer
    // Supplier<T> ... T get() ... 引数がなく返り値があるメソッドを定義
    // Predicate<T> ... boolean test(T t) ... 引数とbooleanの返り値があるメソッドを定義

    // BiFunction<T, U, R> ... R apply(T t, U u)
    // BiConsumer<T, U> ... void accept(T t, U u)

    // Function
    //   |- UnaryOperator<T> -> Function<T, T> ... T apply(T t) ... 同じ型の引数と返り値

    // BiFunction
    //   |- BinaryOperator<T> -> BiFunction<T, T, T> ... T apply(T t1, T t2) ... 同じ型の引数２つと返り値

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(10);
        list.add(8);
        list.add(9);
        list.add(2);
        list.add(11);

        System.out.println(list);
        Collections.sort(list, (x, y) -> compare(x, y));
        System.out.println(list);

        FuncIF<Integer, Integer, String, Boolean> fi = new FuncIF<Integer, Integer, String, Boolean>() {
            @Override
            public Boolean testen(Integer integer, Integer integer2, String s) {
                return null;
            }
        };

        FuncIF<Integer, Integer, String, Boolean> fi2 = (i1, i2, s1) -> Boolean.FALSE;
        System.out.println(fi2.testen(3, 4, "a"));

        Comparator<Integer> co = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        Comparator<Integer> co2 = (Integer o1, Integer o2) -> { return compare(o1, o2); };
        Comparator<Integer> co3 = (o1, o2) -> compare(o1, o2);
        System.out.println(co3.compare(3, 5));

        Runnable task = new Runnable() {
            @Override
            public void run() {
                doLongTask();
            }
        };

        ExecutorService es = Executors.newSingleThreadExecutor();
//        es.submit(task);

        Runnable task2 = () -> doLongTask();
//        es.submit(task2);

        FuncIF2<String, String> fif2 = new FuncIF2<String, String>() {
            @Override
            public String testen(String s) {
                return s;
            }
        };

        FuncIF2<String, String> fif3 = s -> s;

        String st = fif3.testen("PARA");
        System.out.println(st);

        int y = 4;
        y = 2;
//        IntUnaryOperator iuo = x -> x * y;

//        final int z = 3;
        int z = 3;
        IntUnaryOperator iuo2 = x -> x * z;

    }

    public static void doLongTask() {
        try {
            System.out.println("START");
            Thread.sleep(5000);
            System.out.println("END");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
