package Thread;

import java.util.concurrent.Semaphore;

public class Demo45 {
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        //设置 1 0 信号量
        Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 50000; i++) {

                    semaphore.acquire(1);
                    count++;
                    semaphore.release();


                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread t2 = new Thread(() -> {

            try {
                for (int i = 0; i < 50000; i++) {
                    semaphore.acquire(1);
                    count++;
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(count);
    }
}
