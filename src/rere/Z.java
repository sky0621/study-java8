package rere;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Shotaro.S on 2016/02/01.
 */
public class Z {
    public static void p(String s) {
        System.out.println(s);
    }

    public static void p(Object o) {
        String s = String.valueOf(0);
        p(s);
    }

    public static void p(boolean b){
        String s = String.valueOf(b);
        p(s);
    }

    public static void p(int i){
        String s = String.valueOf(i);
        p(s);
    }

    public static void p(Integer i) {
        String s = String.valueOf(i);
        p(s);
    }

    public static void p(Long l) {
        String s = String.valueOf(l);
        p(s);
    }

    public static void p(Double d) {
        String s = String.valueOf(d);
        p(s);
    }

    public static <K, V> void p(Map<K, List<V>> m) {
        Iterator ite = m.keySet().iterator();
        while (ite.hasNext()) {
            Object k = ite.next();
            Z.p("<<<<<<<<<<");
            Z.p(k);
            Z.p(m.get(k));
        }
    }

    public static void p(String[] s) {
        Arrays.asList(s).parallelStream().forEach(Z::p);
    }

    public static <E> void p(List<E> list) {
        list.forEach(System.out::println);
    }

    public static void l() {
        p("------------------------------------");
    }

    public static void s() {
        p(" ");
    }

}
