package next.ch04;

import next.Z;
import scala.actors.threadpool.Arrays;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Shotaro.S on 2016/02/09.
 */
public class M0406_collect_mapping {
    public static void main(String... args){
        List<String> words = Arrays.asList(new String[]{"dog", "cat", "mouse", "rabbit", "bear", "panda", "elephant", "lion", "tiger"});

        List<Integer> wlenList = words.stream().map(w -> w.length()).collect(Collectors.toList());
        Z.p(wlenList);

        Z.l();

        List<Integer> wlenList2 = words.stream().collect(Collectors.mapping(w -> w.length(), Collectors.toList()));
        Z.p(wlenList2);

        Z.l();
    }
}
