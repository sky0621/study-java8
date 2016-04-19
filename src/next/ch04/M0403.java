package next.ch04;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Shotaro.S on 2016/02/06.
 */
public class M0403 {
    public static void main(String... args) {
        List<String> pgs = Arrays.asList("Go", "PHP", "Java", "Scala", "C#", "Python", "C++", "C", "Elixir", "Ruby", "Lisp", "Perl");
        pgs.parallelStream().filter(pg -> pg.contains("a")).sorted().map(pg -> pg.toUpperCase()).forEach(System.out::println);
    }
}
