package redo;

import java.io.IOException;
import java.nio.file.*;


/**
 * Created by Shotaro.S on 2016/01/26.
 */
public class Main3 {
    public static final String APATH = "C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\";
    public static final String NEWS = "news.txt";
    public static final String SLINK = "sakura.txt_slink";

    public static final String RPATH = "..\\..\\news.txt";

    public static final String DEST = "C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\redo\\";
    public static final String DTXT = "dest.txt";
    public static final String DSLINK = "slink";


    public static void main(String... args) throws IOException {

        Path from = Paths.get(APATH + NEWS);
        Path to = Paths.get(DEST + DTXT);
        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);

        Path from2 = Paths.get(APATH + SLINK);
        Path to2 = Paths.get(DEST + DSLINK);
        Files.copy(from2, to2, LinkOption.NOFOLLOW_LINKS);
    }
}
