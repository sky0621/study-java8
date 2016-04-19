package next.ch03;

/**
 * Created by Shotaro.S on 2016/02/01.
 */
public interface Regards extends Greeting {
    @Override
    void sayTo(String person);
}
