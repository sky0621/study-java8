package next.ch04;

import scala.actors.threadpool.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shotaro.S on 2016/02/14.
 */
public class M0406_collect2 {
    public static void main(String... args){
        List<String> wds = Arrays.asList(new String[]{"hush", "a", "bye", "top", "baby", "on", "the", "tree"});

//        wds.stream().collect(
//                supplier Supplier<R>,   // 結果を格納するためのオブジェクトを生成
//                accumulator BiConsumer<R, ? super T>, // 要素ごとに集約処理を行う
//                combiner BiConsumer<R, R>   // 部分集約をまとめる
//        );
        ArrayList<Object> collect = wds.stream().collect(
                () -> new ArrayList<>(),
                (l, w) -> l.add(w),
                (l1, l2) -> l1.addAll(l2)
        );
        System.out.println(collect);

    }
}
