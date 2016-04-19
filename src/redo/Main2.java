package redo;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Shotaro.S on 2016/01/24.
 */
public class Main2 {
    public static void main(String... args){
        FileSystem fs = FileSystems.getDefault();
        Path pt = fs.getPath("foo.txt");

        Path pt2 = Paths.get("./foo.txt");
        print(pt2.toString());
    }

    private static void print(String text) {
        System.out.println(text);
    }
}
