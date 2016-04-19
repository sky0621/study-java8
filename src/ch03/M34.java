package ch03;

/**
 * Created by Shotaro.S on 2015/12/30.
 */
public class M34 implements M34If, M34If2 {

    public static void main(String... args){
        M34 m = new M34();
        m.say("SAYSAY");

        M34If2.sayHello();
    }

    @Override
    public void say(String str) {
//        M34If one = new M34If() {};
//        one.say(str);
//        M34If2 two = new M34If2() {};
//        two.say(str);
        M34If.super.say(str);
        M34If2.super.say(str);
    }
}
