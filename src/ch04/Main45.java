package ch04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Shotaro.S on 2016/01/19.
 */
public class Main45 {
    public static void main(String... args) {
        Stream<String> s = Stream.of("Java", "C#", "Ruby", "Scala", "Closure", "Go", "PHP", "Perl", "C++", "JavaScript");
//        s.filter(pg -> pg.contains("a")).forEach(System.out::println);

        IntStream is = IntStream.range(1, 20);
//        is.filter(i -> i % 2 > 0).forEach(System.out::println);

//        IntStream.of(2, 3, 5, 6, 7, 9, 10, 11, 13, 14, 15, 18, 19).map(n -> n * 2).forEach(System.out::println);

        List<String> texts = Arrays.asList("she loves you", "ticket to ride");

        Stream<String> tst = texts.stream();
//        Stream<Stream<String>> tstst = tst.map(t -> Arrays.stream(t.split(" ")));
//        tstst.forEach(stst -> { stst.forEach(System.out::println); });

        Stream<String> flst = tst.flatMap(t -> Arrays.stream(t.split(" ")));
//        flst.forEach(System.out::println);

        Stream<String> sst = Arrays.asList("Japan", "America", "Australia", "Germany", "America", "France", "Japan", "China").stream();
//        sst.sorted(Comparator.reverseOrder()).forEach(System.out::println);

//        IntStream.iterate(0, i -> i + 2).limit(50L).forEach(System.out::println);

//        IntStream.rangeClosed(0, 20).skip(15L).forEach(System.out::println);

//        Stream.of("Michael Jackson", "Jackson Browne", "George Michael").flatMap(name -> Stream.of(name.split(" "))).peek(name -> System.out.println("After flatMap: "+name))
//                .distinct().peek(name -> System.out.println("After distinct: "+name)).forEach(System.out::println);

        IntStream ist = IntStream.range(0, 10);
//        ist.forEach(System.out::println);
        Stream<Integer> sist = ist.boxed();
//        sist.forEach(System.out::println);

        IntStream.range(0, 10).asDoubleStream().forEach(System.out::println);

    }
}
;