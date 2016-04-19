package next.ch04;

import next.Z;
import scala.actors.threadpool.Arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Shotaro.S on 2016/02/23.
 */
public class M0408 {
    public static void main(String... args) {
        List<String> pgs = Arrays.asList(new String[]{"Java", "Scala", "Go", "Ruby", "PHP", "JavaScript", "C#", "C", "Perl", "C++", "Python"});
        List<String> res = pgs.stream().filter(pg -> pg.contains("J")).collect(Collectors.toList());
        Z.p(res);

        List<Item> items = new ArrayList<>();
        items.add(new Item(3, "Third"));
        items.add(new Item(1, "First"));
        items.add(new Item(2, "Second"));
        List<Item> items2 = new ArrayList<>();
        items2.add(new Item(3, "Third"));
        List<Item> items3 = new ArrayList<>();
        items3.add(new Item(4, "Fourth"));

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(4, "P4", items));
        persons.add(new Person(2, "P2", items2));
        persons.add(new Person(1, "P1", items3));
        persons.add(new Person(3, "P3", items2));

        List<Item> buys = new ArrayList<>();
        for (Person p : persons) {
            for (Item i : p.history) {
                if (!buys.contains(i)) {
                    buys.add(i);
                }
            }
        }
        buys.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.id, o2.id);
            }
        });
        Z.p(buys);

        Z.l();

        List<Item> buys2 = new ArrayList<>();
        persons.stream().forEach(p -> {
            for (Item i : p.history) {
                if (!buys2.contains(i)) {
                    buys2.add(i);
                }
            }
        });
        buys2.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.id, o2.id);
            }
        });
        Z.p(buys2);

        Z.l();

        List<Item> buys3 = persons.stream().flatMap(p -> p.history.stream()).distinct().sorted((i1, i2) -> Integer.compare(i1.id, i2.id)).collect(Collectors.toList());
        Z.p(buys3);

        Z.l();

        List<Person2> persons2 = new ArrayList<>();
        persons2.add(new Person2(4, "P4", items, "Tokyo"));
        persons2.add(new Person2(2, "P2", items2, "Osaka"));
        persons2.add(new Person2(1, "P1", items3, "Tokyo"));
        persons2.add(new Person2(3, "P3", items2, "Nagoya"));
        persons2.add(new Person2(5, "P5", items2, "Osaka"));
        persons2.add(new Person2(6, "P6", items3, "Tokyo"));

        Map<String, List<Person2>> maps = new HashMap<>();
        for(Person2 p2 : persons2) {
            String area = p2.area;
            List<Person2> tp2 = maps.getOrDefault(area, new ArrayList<>());
            tp2.add(p2);
            maps.put(area, tp2);
        }
        Z.p(maps);

        Z.l();

        Map<String, List<Person2>> maps2 = persons2.stream().collect(Collectors.groupingBy(p2 -> p2.area));
        Z.p(maps2);
    }
}

class Person {
    public int id;
    public String name;
    public List<Item> history;

    public Person(int id, String name, List<Item> history) {
        this.id = id;
        this.name = name;
        this.history = history;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", history=" + history +
                '}';
    }
}

class Item {
    public int id;
    public String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class Person2 {
    public int id;
    public String name;
    public List<Item> history;
    public String area;

    public Person2(int id, String name, List<Item> history, String area) {
        this.id = id;
        this.name = name;
        this.history = history;
        this.area = area;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", history=" + history +
                ", area='" + area + '\'' +
                '}';
    }
}
