package redo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shotaro.S on 2016/01/24.
 */
public class Main {
    public static void main(String... args) {
        // Java7: 文字列のswitch
        testSwitch("Java");
        testSwitch("Ruby");
        testSwitch("C#");

        // Java7: 数値リテラルの区切り文字
        int x = 1_234_567;
        int y = 10000;
        print(String.valueOf(x));
        if (y < 10_001) {
            print("Under");
        }

        // Java7: 例外のマルチキャッチ
        makeInstance("OgoOgo");

        // Java7: ジェネリクス型パラメータの省略
        List<String> strList = new ArrayList<>();

        // Java7: リソースの自動クローズ

        //
    }

    static void testSwitch(String text) {
        switch (text) {
            case "Java":
                print("Java");
                break;
            case "Ruby":
                print("Ruby");
                break;
            default:
                print("Other");
        }
    }

    static <T> T makeInstance(String name) {
        Class cls = null;
        try {
            cls = Class.forName(name);
            return (T) cls.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void print(String text) {
        System.out.println(text);
    }
}
