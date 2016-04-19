package next.ch03;

import java.util.function.Consumer;

/**
 * Created by Shotaro.S on 2016/02/03.
 */
public class Envelope<T> {
    private T contents;

    private Envelope(T contents){
        this.contents = contents;
    }

    public static <S> Envelope<S> create(S contents){
        return new Envelope<S>(contents);
    }

    public void print(Consumer<T> consumer){
        consumer.accept(contents);
    }
}
