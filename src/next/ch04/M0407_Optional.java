package next.ch04;

import scala.actors.threadpool.Arrays;

import java.util.List;

/**
 * Created by Shotaro.S on 2016/02/23.
 */
public class M0407_Optional {
    public static void main(String... args){
        // Optional
        // empty()
        // of(T value)
        // ofNullable(T value)

        // get()
        // orElse(T value)
        // orElseGet(Supplier<? extends T> supplier)
        // <X extends Throwable> orElseThrow(Supplier<? extends X> exceptionSupplier)

        // ifPresent
        List<String> words = Arrays.asList(new String[]{"dog", "cat", "mouse", "rabbit", "bear", "panda", "monkey", "elephant", "lion", "tiger"});
        words.stream().filter(w -> w.startsWith("m")).findFirst().ifPresent(System.out::println);
    }
}
