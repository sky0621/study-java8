package next.ch04;

import next.Z;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Shotaro.S on 2016/02/06.
 */
public class M0404 {
    public static void main(String... args){
        String[] pgs = {"Go", "PHP", "Java", "Scala", "C#", "Python", "C++", "C", "Elixir", "Ruby", "Lisp", "Perl"};
        Stream<String> stSt = Arrays.stream(pgs);
        Stream<String> stSt2 = Arrays.stream(pgs, 2, 8);

        stSt.filter(pg -> pg.startsWith("P")).forEach(System.out::println);
        Z.l();
        stSt2.forEach(System.out::println);

        Z.l();
        try(Stream<String> st = Files.lines(Paths.get("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\next\\ch04\\lang.txt"))){

            st.map(pg -> pg.toLowerCase()).filter(pg -> pg.contains("p")).forEach(System.out::println);

        }catch(IOException e){
            Z.p(e.getMessage());
        }
    }
}
