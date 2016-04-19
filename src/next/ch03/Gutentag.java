package next.ch03;

import next.Z;

/**
 * Created by Shotaro.S on 2016/02/01.
 */
public interface Gutentag extends Greeting {
    @Override
    default void sayTo(String person){
        Z.p("Gutentag, "+person);
    }
}
