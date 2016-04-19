package ch02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Shotaro.S on 2015/12/22.
 */
public class Main4 {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src\\ch02\\fl.txt");
        List<String> strings = Files.readAllLines(path);
        strings.stream().forEach(System.out::println);


    }
}
