package ch02;

import com.sun.jndi.toolkit.url.Uri;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Shotaro.S on 2015/12/22.
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException {

        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("201512.csv");
        System.out.println(path.toString());

        Path foo = Paths.get("foo", "201512.csv");
        System.out.println(foo.toString());

        Path path1 = Paths.get("C", "Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\ch02\\foo", "201512.csv");
        System.out.println(path1.toString());

        Path path2 = Paths.get(new URI("file:/C:/Users/Shotaro.S/IdeaProjects/Java7and8/src/ch02/foo/201512.csv"));
        System.out.println(path2.toString());

        Path foo1 = Paths.get("cat.zip");
        System.out.println(foo1.toString());

//        try(FileSystem zipFS = FileSystems.newFileSystem(foo1, ClassLoader.getSystemClassLoader())) {
//
//            Path path3 = zipFS.getPath("flickr-cat.png");
//            System.out.println(path3.toString());
//
//        } catch(IOException ex) {
//            // log
//        }

        System.out.println("=----------------------");

        Path p2 = Paths.get("./201512.csv");
        Path p2a = p2.toAbsolutePath();
        System.out.println(p2a.toString());
        Path p2n = p2.normalize();
        Path p2na = p2n.toAbsolutePath();
        System.out.println(p2na);

        URI u = p2na.toUri();
        System.out.println(u.toString());
    }

}
