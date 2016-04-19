package next.ch03;

import next.Z;

import java.util.Comparator;

/**
 * Created by Shotaro.S on 2016/02/03.
 */
public class M03072 {
    public static void main(String... args){
        Comparator<Person> comparator = (p1, p2) -> {
            String last1 = p1.getLast();
            String last2 = p2.getLast();
            int res = last1.compareTo(last2);

            if(res != 0){
                return res;
            }

            return p1.getFirst().compareTo(p2.getFirst());
        };

        Comparator<Person> lastNameComparator = (p1, p2) -> {
            return p1.getLast().compareTo(p2.getLast());
        };

        Comparator<Person> firstNameComparator = (p1, p2) -> {
            return p1.getFirst().compareTo(p2.getFirst());
        };

        // 関数合成
        Comparator<Person> fullNameComparator = lastNameComparator.thenComparing(firstNameComparator);

        // Function
        //     #andThen(Function after) ... Functionやってからafterやる
        //     #compose(Function before) ... beforeやってからFunctionやる
        // Consumer
        //     #andThen(Consumer t) ... Consumerで引数に処理してからtで引数に処理する
        // Predicate
        //     #and(Predicate other) ... 同じ引数をPredicateとotherに適用して”論理積”を返す
        //     #or(Predicate other) ... 同じ引数をPredicateとotherに適用して”論理和”を返す

        Z.l();


    }

    class Person {
        private String first;
        private String last;

        public Person(String first, String last){
            this.first = first;
            this.last = last;
        }

        public String getFirst() {
            return first;
        }

        public String getLast() {
            return last;
        }
    }
}
