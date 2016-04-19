package next.ch03;

import next.Z;

/**
 * Created by Shotaro.S on 2016/02/01.
 */
public class CasualGreeting implements Greeting, Hello, Gutentag {
    public static void main(String... args){
        new Greeting(){}.sayTo("Taro");
        new Hello(){}.sayTo("Jiro");
        new Gutentag(){}.sayTo("Saburo");
        new CasualGreeting().sayTo("Shiro");
    }

    @Override
    public void sayTo(String person){
        Z.p("Impl, "+person);
    }
}
