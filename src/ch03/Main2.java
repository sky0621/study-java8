package ch03;

import java.util.function.Supplier;

/**
 * Created by Shotaro.S on 2015/12/30.
 */
public class Main2 {

    public Main2(){
        Supplier<Void> func1 = new Supplier<Void>() {
            @Override
            public Void get() {
                System.out.println("Task1 class: "+this.getClass());
                return null;
            }
        };
        Supplier<Void> func2 = () -> {
            System.out.println("Task2 class: "+this.getClass());
            return null;
        };

        func1.get();
        func2.get();
    }
    public static void main(String... args){
        new Main2();
    }

}
