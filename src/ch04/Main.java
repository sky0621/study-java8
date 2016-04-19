package ch04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Shotaro.S on 2016/01/12.
 */
public class Main {
    // 外部イテレータ　・・・拡張for文のように、コレクションの外部でイテレーションを制御
    // 内部イテレータ　・・・Iteratable#forEachのように、コレクション内でイテレーションを制御

    // ストリームは、イテレーションの結果を集約して値を返す
    // ストリームは、リストなどと異なり、、自ら要素を保持しない
    // ストリームの対象となるリストや配列のことを、ソースと呼ぶ

    public static void main(String... args) {
        String[] wds = new String[]{ "C", "Java", "Scala", "C++", "PHP", "Ruby", "C#", "JavaScript", "Python", "Go" };
        List<String> words = Arrays.asList(wds);
        long size = words.stream().filter(w -> w.startsWith("J")).count();
//        System.out.println(size);
        List<String> done = words.stream().filter(w -> w.contains("a")).collect(Collectors.toList());
//        System.out.println(done);

        Stream<String> wdStrm = Arrays.stream(wds);
        Stream<String> wdStrm2 = Arrays.stream(wds, 2, 5);
//        wdStrm.filter(w -> w.endsWith("a")).forEach(System.out::println);
//        line();
//        wdStrm2.filter(w->w.endsWith("a")).forEach(System.out::println);
//        line();

        int[] gusus = new int[]{2, 4, 6, 8, 10, 12};
//        Arrays.stream(gusus).filter(n -> n>4 && n<12).forEach(System.out::println);
//        line();

        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\ch04\\lang.txt"))){
//            reader.lines().forEach(System.out::println);
        }catch (IOException e){
            line(e.getMessage());
        }

        Stream<String> ss = Stream.of("PHP", "Python", "Ruby", "Go", "Pluto", "Java");
//        line(ss.findFirst().get());
        IntStream is = IntStream.of(1, 3, 5, 7, 9, 11);
//        is.forEach(System.out::println);

//        IntStream.range(0, 10).forEach(System.out::println);
//        line();
//        IntStream.rangeClosed(0, 10).forEach(System.out::println);
//        line();

//        IntStream.iterate(0, n -> n + 2).limit(50).forEach(System.out::println);

        Random r = new Random();
//        r.ints(10, 0, 100).forEach(System.out::println);

        Path p = Paths.get("C:\\FHS\\usr");
        try {
            Files.list(p).forEach(System.out::println);
            line();
//            Files.walk(p).forEach(System.out::println);

            Files.find(p, 4, (x, attr) -> x.toString().endsWith(".txt")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void line(String... str){
        if(str.length==0){System.out.println("-----------------------------"); return; }
        for (String s : str) {
            System.out.println(s);
        }
    }
}
