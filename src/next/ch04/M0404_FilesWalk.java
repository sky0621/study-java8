package next.ch04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Shotaro.S on 2016/02/06.
 */
public class M0404_FilesWalk {
    public static void main(String... args){
        try {
            Files.walk(Paths.get("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\next")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
