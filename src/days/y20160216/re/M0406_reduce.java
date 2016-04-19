package days.y20160216.re;

import days.Z;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Shotaro.S on 2016/02/16.
 */
public class M0406_reduce {
    public static void main(String... args) {
        // reduce = 前回値までの集約結果に今回値を集約していく処理
        // T reduce(T identity, BinaryOperator<T> accumulator) ... 「初期値」と「集約処理」を渡す
        // accumelator.apply(Ri-1, Si)
        // 初期値＝単位元
        // 集約処理の１回目は単位元が返るようにする必要がある

        int sum = IntStream.rangeClosed(0, 3).reduce(0, (total, now) -> total + now);
        Z.p(sum);

        int sum2 = IntStream.rangeClosed(0, 5).reduce(0, (total, now) -> total + now);
        Z.p(sum2);

        int sum3 = IntStream.rangeClosed(0, 3).reduce(0, (total, now) -> total * now);
        Z.p(sum3);

        int sum4 = IntStream.rangeClosed(1, 3).reduce(1, (total, now) -> total * now);
        Z.p(sum4);

        // 単位元を省略する場合は戻り値が Optional 系になる
        OptionalInt sum5 = IntStream.rangeClosed(1, 3).reduce((total, now) -> total * now);
        Z.p(sum5.getAsInt());

        // 文字列連結
        String s = Stream.of("Go, ", "Java, ", "Scala, ", "Ruby").reduce("[init]", (total, now) -> {
            StringBuilder sb = new StringBuilder();
            return sb.append(total).append(now).toString();
        });
        Z.p(s);

        // U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
        StringBuilder sb = Stream.of("Go, ", "Java, ", "Scala, ", "Ruby").reduce(
                new StringBuilder("[init]"),
                (total, now) -> total.append(now),
                (total1, now1) -> total1.append(now1)
        );
        Z.p(sb.toString());

    }

}
