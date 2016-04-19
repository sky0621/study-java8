package next.ch03;

import next.Z;

/**
 * Created by Shotaro.S on 2016/02/01.
 */
public interface Greeting {
    default void sayTo(String person){
        Z.p("Nice to meet you, " + person + "!");
    }
}
