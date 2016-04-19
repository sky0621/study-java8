package ch02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Paths.get;

/**
 * Created by Shotaro.S on 2015/12/22.
 */
public class Main3 {


    public static void main(String[] args) throws IOException {

        Path from = get("src\\ch02\\fl.txt").toAbsolutePath();
        Path to = get("baa.txt");
//        Path move = Files.move(from, to);

        Path path = get("src\\ch02\\fl.txt");
//        Files.copy(path, Paths.get("src\\ch02\\tmp\\fl3.txt"));
//        Path link = Files.createLink(Paths.get("src\\ch02\\link\\fll.txt"), path);
        Files.createSymbolicLink(Paths.get("src\\ch02\\link\\fls.txt"), path);
    }

}
