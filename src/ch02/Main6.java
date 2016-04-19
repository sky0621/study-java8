package ch02;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Shotaro.S on 2015/12/28.
 */
public class Main6 {

    public static void main(String[] args) throws IOException {

        FileVisitor<Path> visitor = new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                o("Pre: ", dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                o("Visit: ", file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                o("Fail: ", file);
                return FileVisitResult.TERMINATE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                o("Post: ", dir);
                return FileVisitResult.CONTINUE;
            }

            private void o(String s, Path p){
                String ps = p.getFileName().toString();
                if(ps.contains("git")) {
                    return;
                }
                System.out.println(s + p);
            }
        };

        Path p = Paths.get("C:\\temp");
        Files.walkFileTree(p, visitor);
    }

}
