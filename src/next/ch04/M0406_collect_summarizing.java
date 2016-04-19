package next.ch04;

import next.Z;
import scala.actors.threadpool.Arrays;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Shotaro.S on 2016/02/09.
 */
public class M0406_collect_summarizing {
    public static void main(String... args){
        // 要素数が１００、最小値が０、最大値が９９のリスト
        List<Integer> randoms = new Random().ints(100, 0, 100).boxed().collect(Collectors.toList());

        Z.p("要素数が１００、最小値が０、最大値が９９のリストから、２通りのサイズの取得、最大値、最小値を表示");

        Z.p(randoms.size());

        Z.p(randoms.stream().collect(Collectors.counting()));

        Z.p(randoms.stream().collect(Collectors.maxBy(Integer::compare)).get());

        Z.p(randoms.stream().collect(Collectors.minBy(Integer::compare)).get());

        Z.l();

        Z.p("英単語のリストから、単語長の合計と単語当たりの平均文字数を求める");

        List<String> words = Arrays.asList(new String[]{"dog", "cat", "mouse", "rabbit", "bear", "panda", "elephant", "lion", "tiger"});

        Z.p(words.stream().collect(Collectors.summingInt(w -> w.length())));

        Z.p(words.stream().collect(Collectors.averagingInt(w -> w.length())));

        Z.l();

        Z.p("英単語のリストから、単語数、単語長の平均、最大値、最小値、合計を求める");

        IntSummaryStatistics istatics = words.stream().collect(Collectors.summarizingInt(w -> w.length()));
        Z.p("Count: " + istatics.getCount());
        Z.p("Average: " + istatics.getAverage());
        Z.p("Max: " + istatics.getMax());
        Z.p("Min: " + istatics.getMin());
        Z.p("Sum: " + istatics.getSum());
    }
}
