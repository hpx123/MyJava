package Thread_Text01;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;

public class AllState {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("lixiannnn");
        });

        Thread.State state = t.getState();
        System.out.println(state);

        t.start();
        state = t.getState();
        System.out.println(state);
    }
}
