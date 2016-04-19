package rere.ch02;

import rere.Z;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Shotaro.S on 2016/03/15.
 */
public class M0202 {
    public static void main(String... args) {
        //File fl = new File("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\rere\\ch02\\201601.csv");

        // 仮想的なファイルシステムも扱える（ＺＩＰファイル、シンボリックリンクなど）
        FileSystem fileSystem = FileSystems.getDefault();
        Path path = fileSystem.getPath("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\rere\\ch02\\201601.csv");

        Path path1 = Paths.get("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\rere\\ch02\\201601.csv");
        try {
            Path path2 = Paths.get(new URI("file://C:/Users/Shotaro.S/IdeaProjects/Java7and8/src/rere/ch02/201601.csv"));
            Z.p(path2.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Path zipPath = Paths.get("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\rere\\ch02\\201601.zip");
        try (FileSystem zipFS = FileSystems.newFileSystem(zipPath, ClassLoader.getSystemClassLoader())) {
            Path csvPath = zipFS.getPath("201601.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path csvPs = Paths.get("src\\rere\\ch02\\201601.csv");
        Path csvPsAbs = csvPs.toAbsolutePath();
        Z.p(csvPsAbs.toString());

        Path cP = Paths.get("..\\..\\..\\201601.csv");
        Path cPa = cP.toAbsolutePath();
        Z.p(cPa.toString());

        Path cP2 = Paths.get("../../../201601.csv");
        Path cPna = cP2.normalize();
        Z.p(cPna.toString());

    }
}
