package next.ch04;

import days.Z;

/**
 * Created by Shotaro.S on 2016/03/08.
 */
public class M0409_ForkJoin {
    public static void main(String... args) {

        int sm = sum(new int[]{3, 8, 1, 2, 9, 5, 0, 7}, 0, 7);
        Z.p(sm);
    }

    private static int sum(int[] array, int start, int end) {

        if(start == end) return array[start];

        int divIdx = (start + end) / 2;

        int leftSum = sum(array, start, divIdx);
        int rightSum = sum(array, divIdx + 1, end);

        Z.p("[start:"+start+"][end:"+end+"][divIdx:"+divIdx+"] => {leftSum:"+leftSum+"}{rightSum:"+rightSum+"}");
//        Z.p("{leftSum:"+leftSum+"}{rightSum:"+rightSum+"}");
        return leftSum + rightSum;
    }
}
