package next.ch04;

import next.Z;
import redo.Zzz;
import scala.actors.threadpool.Arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Shotaro.S on 2016/02/09.
 */
public class M0406_groupingBy {
    public static void main(String... args) {
        List<String> words = Arrays.asList(new String[]{"red", "green", "blue", "purple", "black", "yellow", "glay", "pink"});

//        Z.p("単語の１番目の文字をキーにグルーピング");
        Map<String, List<String>> result = words.stream().collect(Collectors.groupingBy(w -> w.substring(0, 1)));
//        Z.p(result);

        List<String> wds = Arrays.asList(new String[]{"hush", "a", "bye", "top", "baby", "on", "the", "tree"});
        Map<String, Long> res = wds.stream().collect(Collectors.groupingBy(
                w -> w.substring(0, 1),
                () -> new TreeMap<>(),
                Collectors.counting()));
        System.out.println(res);

        Map<Boolean, List<String>> wlen = wds.stream().collect(Collectors.partitioningBy(w -> w.length() > 2));
        System.out.println(wlen);

        Zzz.p("-----------------------");

        Map<String, List<String>> cl = wds.stream().collect(Collectors.toMap(
                w -> w.substring(0, 1),
                w -> {
                    List<String> list = new ArrayList<>();
                    list.add(w);
                    return list;
                },
                (u, v) -> {
                    u.addAll(v);
                    return u;
                }));
        System.out.println(cl);

        Zzz.p(("===================="));

        Set<String> ts = wds.stream().collect(Collectors.toSet());
        System.out.println(ts);
    }
}
