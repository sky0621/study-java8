package next.ch04;

import next.Z;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Shotaro.S on 2016/02/06.
 */
public class M0406_reduce {
    public static void main(String... args) {
        // reduce ... 前回値までの集約結果に、今回値を集約していく処理
        //   T reduce(T identity, BinaryOperator<T> accumulator)
        //           [1].集約処理の初期値 ----- R0 = identity = [ S0 = apply(R0, S0) ]
        //           [2].集約処理         ----- Ri = apply(Ri-1, Si)

        int sum = IntStream.rangeClosed(0, 3).reduce(0, (prv, prs) -> prv + prs);
        //      集約値＋今回値
        // n0 ... 0 + 0
        // n1 ... 0 + 1
        // n2 ... 1 + 2
        // n3 ... 3 + 3 = 6
        Z.p(sum);

        Optional<String> opt = Stream.of("Hello,", "Taro! ", "I'm ", "Jiro.").reduce((s1, s2) -> s1 + s2);
        Z.p(opt.get());

        Z.l();

        Z.p(Stream.of("Hello, ", "Saburo.").reduce(
                new StringBuilder(),
                (bld, t) -> bld.append(t),
                (b1, b2) -> b1.append(b2)
        ).toString());

        Z.l();

        // collect
        //   Collectors.toList()

        List<Integer> nums = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        for(int i : nums){
//            Z.p(i);
        }

//        Z.l();

        Integer[] numAry = {20, 10, 5, 1};
//        Z.p(Arrays.asList(numAry).stream().filter(n -> n % 2 == 0).reduce((n1, n2) -> n1 + n2).get());
    }

}
