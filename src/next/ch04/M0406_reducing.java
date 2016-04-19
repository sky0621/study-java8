package next.ch04;

import next.Z;
import scala.actors.threadpool.Arrays;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Shotaro.S on 2016/02/09.
 */
public class M0406_reducing {
    public static void main(String... args){
        List<String> words = Arrays.asList(new String[]{"dog", "cat", "mouse", "rabbit", "bear", "panda", "elephant", "lion", "tiger"});

        Integer total = words.stream().map(w -> w.length()).reduce(0, (lenTotal, len) -> lenTotal + len);
        Z.p(total);

        Integer total2 = words.stream().map(w -> w.length()).collect(Collectors.reducing(0, (lenTotal, len) -> lenTotal + len));
        Z.p(total2);
    }
}
