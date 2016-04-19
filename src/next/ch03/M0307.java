package next.ch03;

import next.Z;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Shotaro.S on 2016/02/02.
 */
public class M0307 {
    public static void main(String... args){
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(8);
        Collections.sort(list, (x, y) -> Integer.compare(x, y));
        list.forEach(System.out::println);

        Envelope<String> container = Envelope.create("Hello, Taro");
        container.print(contents -> System.out.println(contents.toString()));

        container.print(contents -> {
            Path p = Paths.get("contents.txt");
            try {
                Files.write(p, contents.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Z.l();

        Collections.sort(list, reverse((x, y) -> Integer.compare(x, y)));
        Z.p(list);
    }

    public static <T> Comparator<T> reverse(Comparator<T> comparator){
        return (x, y) -> comparator.compare(y, x);
    }

}
