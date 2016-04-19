package redo;

import next.Z;
import scala.actors.threadpool.Arrays;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Shotaro.S on 2016/03/01.
 */
public class MM {
    public static void main(String... args){
        String pgs = "java,scala,php,ruby,python,perl,go,c++,javascript,c#,c";
        Stream<String> pgStream = Stream.of(pgs.split(pgs));
        pgStream.parallel();
        Z.p(pgStream.isParallel());
        Z.p(pgStream.anyMatch(pg -> pg.contains("z")));

        Stream<String> strm = Stream.of(pgs.split(pgs));
        IntStream intStream = strm.mapToInt(pg -> pg.length());
        intStream.forEach(System.out::println);

        List<String> pgList = Arrays.asList(new String[]{"java","scala","php","ruby","c++","perl","c","javascript","c#","python","go"});
//        pgList.stream().forEach(System.out::println);
//        Z.p(pgList.parallelStream().reduce((pg1, pg2) -> pg1.concat(pg2)).get());
//        Optional<String> opt = Stream.of("java","scala","php","ruby","c++","perl","c","javascript","c#","python","go").reduce(
//                new StringBuilder(),
//                (pg1,pg2) -> pg1.append(pg2),
//                (bld1,bld2) -> bld1.append(bld2)
//        );
//        Z.p(opt.get());

        Z.p(Stream.of("java","scala","php","ruby","c++","perl","c","javascript","c#","python","go").reduce(
                new StringBuilder(),
                (bld, t) -> bld.append(t),
                (b1, b2) -> b1.append(b2)
        ).toString());

    }
}
