package thread;

import java.util.Timer;
import java.util.TimerTask;

public class Demo39 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(3333);
            }
        }, 3333);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(2222);
            }
        }, 2222);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(1111);
            }
        }, 1111);
    }
}
