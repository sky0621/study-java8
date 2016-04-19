package next.ch04;

import next.Z;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Shotaro.S on 2016/02/06.
 */
public class M0405_mapToInt {
    public static void main(String... args){
        IntStream.of(1, 2, 3, 4, 5).map(n -> n * 2).forEach(System.out::println);
        Z.l();
        Stream.of("1","2","3","4","6").mapToInt(n -> Integer.parseInt(n) * 3).forEach(System.out::println);
    }
}
