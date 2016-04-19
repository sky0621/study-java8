package days.y20160216.re;

import next.Z;
import scala.actors.threadpool.Arrays;

import java.util.List;
import java.util.stream.Collector;

/**
 * Created by Shotaro.S on 2016/02/16.
 */
public class M0406_CollectorInterface {
    public static void main(String... args){
        // Collectorインタフェースのメソッド
        // supplier Supplier<A> -> 集約結果を保持させるオブジェクトを生成する関数を返す
        // accumulator BiConsumer<A, T> -> 要素ごとに行う集約処理を行う関数を返す
        // combiner BinaryOperator<A> -> 部分集約をまとめる関数を返す
        // finisher Function<A, R> -> 集約結果の型 A から、最終的な結果 R へ変換する関数を返す
        // characteristics Set<Collector.Characteristics> -> Collectorインタフェースの実装クラスの特性を示すセットを返す
        Collector<String, StringBuilder, String> collector = Collector.of(
                () -> new StringBuilder(),
                (builder, s) -> builder.append(s.toUpperCase()).append(", "),
                (builder1, builder2) -> builder1.append("["+builder2+"]"),
                builder -> builder.toString()
        );
        List<String> wds = Arrays.asList(new String[]{"hush", "a", "bye", "top", "baby", "on", "the", "tree"});
        String res = wds.stream().collect(collector);
        Z.p(res);
    }
}
