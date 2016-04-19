package ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.IntFunction;

/**
 * Created by Shotaro.S on 2015/12/30.
 */
public class M36 {

    public static void main(String... args) {

        List<String> list = new ArrayList<String>();
        list.add("C");
        list.add("Java");
        list.add("Scala");

//        list.forEach(l -> System.out.println(l));
//        list.forEach(System.out::println);

        // ラムダ式でstaticメソッドをコール！
//        BiConsumer<Integer, String> cons1 = (cnt, text) -> M36Ref.ref(cnt, text);
//        cons1.accept(5, "Test");

        // クラスメソッド参照でstaticメソッドをコール！
//        BiConsumer<Integer, String> cons2 = M36Ref::ref;
//        cons2.accept(3, "Sub");

        BiFunction<String, String, String> func1 = (text, concatText) -> text.concat(concatText);
        System.out.println(func1.apply("One", "Two"));

        BiFunction<String, String, String> func2 = String::concat;
        System.out.println(func2.apply("One", "Two"));

        IntFunction<String[]> func = (size) -> new String[size];
        for(String s : func.apply(5)){
            System.out.println(s);
        }

        System.out.println("----------------");

        IntFunction<String[]> funci = String[]::new;
        for(String s : funci.apply(6)){
            System.out.println(s);
        }

    }
}
