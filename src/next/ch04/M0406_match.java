package next.ch04;

import next.Z;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Created by Shotaro.S on 2016/02/23.
 */
public class M0406_match {
    public static void main(String... args){
        int[] numbers = {2, 2};
        boolean allEvens = Arrays.stream(numbers).allMatch(n -> n == 2);
        Z.p(allEvens);

        int[] numMin = {3, 9, 22, 8, 9, 11};
        OptionalInt min = Arrays.stream(numMin).min();
        Z.p(min.getAsInt());

    }
}
