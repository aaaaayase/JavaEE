package Thread;

import java.util.concurrent.*;

public class Demo34 {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(10);

        Thread t1 = new Thread(() -> {
            int count = 1;
            while (true) {
                System.out.println("t1生产:" + count);
                try {
                    blockingQueue.put(count);
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
                    blockingQueue.put(count);
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
                    System.out.println("t3消费:" + blockingQueue.take());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        });


        t2.start();
        Thread.sleep(1000);
        t3.start();
    }


}
