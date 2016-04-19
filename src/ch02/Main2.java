package ch02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Shotaro.S on 2015/12/22.
 */
public class Main2 {

    public static void main(String[] args) throws IOException {

        Path p = Paths.get("201512.csv");
        File f = p.toFile();
        Path p2 = f.toPath();
        System.out.println(p.equals(p2));

//        Path path = Paths.get("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\ch02");
        Path path = Paths.get("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\ch02\\fl.txt");
        Path path1 = Paths.get("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\ch02\\tmp\\fl2.txt");
        Path copy = Files.copy(path, path1);
        System.out.println(copy.toString());
    }

}
