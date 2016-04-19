package next.ch04;

import next.Z;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by Shotaro.S on 2016/02/06.
 */
public class M0404_StreamFactory {
    public static void main(String... args){
        // of ... 可変長の要素を引数にしたストリームを生成
        // range ... 範囲を指定してストリームを生成（終値を含まない）
        // rangeClosed ... 範囲を指定してストリームを生成（終値を含む）
        // iterate ... 初期値に対し関数を繰り返し適用することでストリームを生成
        // generate ... 関数を繰り返し適用することでストリームを生成
        // empty ... 空のストリームを生成
        // concat ... ２つのストリームを連携したストリームを生成

        Stream.of("Go", "Java", "C#", "Ruby").forEach(System.out::println);
        Z.l();
        IntStream.range(0, 10).forEach(System.out::println);
        Z.l();
        LongStream.rangeClosed(3, 9).forEach(System.out::println);
        Z.l();
        IntStream.iterate(1, n -> n * 3).limit(5).forEach(System.out::println);
        Z.l();
        Z.p(Stream.generate(() -> "TEST").findFirst().get());
    }
}
