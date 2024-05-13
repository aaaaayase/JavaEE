package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo41 {
    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                //count++ 这里的对count的修改都是原子的
                count.getAndIncrement();
                //++count
                //count.incrementAndGet();
                //--count
                //count.decrementAndGet();
                //count--
                //count.getAndDecrement();
                //count+=10;
                //count.getAndAdd(10);
            }
        });

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 50000; i++) {
                count.getAndIncrement();
            }
        });

        t.start();
        t1.start();

        t.join();
        t1.join();
        System.out.println(count);


    }
}
