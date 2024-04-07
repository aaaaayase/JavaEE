package Thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Demo34 {

    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>(1000);

        Thread t1 = new Thread(() -> {
            int count = 1;
            while (true) {
                System.out.println("t1生产:" + count);
                try {
                    blockingDeque.put(count);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
            }
        });


        Thread t2 = new Thread(() -> {
            int count = 1;
            while (true) {
                System.out.println("t2生产:" + count);
                try {
                    blockingDeque.put(count);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
            }
        });

        Thread t3 = new Thread(() -> {

            try {
                while (true) {
                    System.out.println("t3消费:" + blockingDeque.take());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        });

        t1.start();
        t2.start();
        Thread.sleep(1000);
        t3.start();
    }


}
