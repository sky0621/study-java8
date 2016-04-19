package ch01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shotaro.S on 2015/12/18.
 */
public class Main {

    public static void main(String[] args) {
        int x = 6000;
        int y = x & 0b111;
        System.out.println(y);

        int a = 100_555_001;
        System.out.println(a);


        Map<Integer, List<String>> rMap = new HashMap<>();
    }

}
