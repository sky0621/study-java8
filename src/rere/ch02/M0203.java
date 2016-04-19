package rere.ch02;

import days.Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Shotaro.S on 2016/03/15.
 */
public class M0203 {
    public static void main(String... args){
        Path path = Paths.get("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\rere\\ch02\\201601.csv");
        Path path1 = Paths.get("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\rere\\ch02\\201601_copy.csv");
        try {
            Files.copy(path, path1, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path cre = Paths.get("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\rere\\ch02\\dum.csv");
        try {
//            Files.createFile(cre);
//            Files.createDirectories(Paths.get("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\rere\\ch02\\demo"));
//            Files.createLink(Paths.get("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\rere\\ch02\\ln.lnk"), cre);
//            Files.createSymbolicLink(Paths.get("C:\\Users\\Shotaro.S\\IdeaProjects\\Java7and8\\src\\rere\\ch02\\slink.lnk"), cre);
            List<String> strings = Files.readAllLines(path);
            strings.stream().forEach( System.out::println );
        } catch (IOException e) {
            e.printStackTrace();
        }

        Z.p(" ");
        Z.l();
        Z.p(" ");

        try (BufferedReader br = Files.newBufferedReader(path)) {
            List<String> contents = new ArrayList<>();
            for(;;){
                String line = br.readLine();
                if(line==null) break;
                contents.add(line);
            }
            contents.parallelStream().forEach(Z::p);
        }catch(IOException e){
            e.printStackTrace();
        }

        Logger global = Logger.getGlobal();
        global.log(Level.INFO, "logloglogn");
    }
}
