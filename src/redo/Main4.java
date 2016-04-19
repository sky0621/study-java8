package redo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Shotaro.S on 2016/02/14.
 */
public class Main4 {
    public static void main(String... args){
        Path csv = Paths.get("src\\redo\\201601.csv").toAbsolutePath();
        try(Stream<String> lines = Files.lines(csv)) {
            Zzz.p("--- 合計 ---");
            Integer collect = lines.skip(1).collect(Collectors.summingInt(line -> Integer.parseInt((line.split(","))[2])));
            Zzz.p(String.valueOf(collect));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(Stream<String> lines = Files.lines(csv)) {
            IntSummaryStatistics collect = lines.skip(1).collect(Collectors.summarizingInt(line -> Integer.parseInt((line.split(","))[2])));
            Zzz.p("--- 最大値 ---");
            Zzz.p(String.valueOf(collect.getMax()));
            Zzz.p("--- 最小値 ---");
            Zzz.p(String.valueOf(collect.getMin()));
            Zzz.p("--- 平均値 ---");
            Zzz.p(String.valueOf(collect.getAverage()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
