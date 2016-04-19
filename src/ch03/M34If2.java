package ch03;

/**
 * Created by Shotaro.S on 2015/12/30.
 */
public interface M34If2 {

    default void say(String str) {
        System.out.println(str + " 2");
    }

    public static void sayHello() {
        System.out.println("Hello!!!!!!!!!!!");
    }
}
