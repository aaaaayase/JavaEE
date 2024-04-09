package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;

class MyArrayBlockingQueue {
    private volatile int head = 0;
    private volatile int tail = 0;
    private volatile int len = 0;
    private String[] blockQueue;

    private int size;

    public MyArrayBlockingQueue(int capacity) {

        blockQueue = new String[capacity];
        size = capacity;
    }


    public void put(String str) throws InterruptedException {
        synchronized (this) {
            while (len == size) {
                this.wait();
            }

            blockQueue[tail] = str;
            tail++;

            if (tail >= blockQueue.length) {
                tail = 0;
            }
            len++;
            this.notify();
        }

    }

    public String take() throws InterruptedException {
        synchronized (this) {
            while (len == 0) {
                this.wait();
            }

            String ret = blockQueue[head];
            head++;
            if (head >= size) {
                head = 0;
            }
            len--;
            this.notify();
            return ret;
        }
    }
}

public class Demo35 {


    public static void main(String[] args) throws InterruptedException {
        MyArrayBlockingQueue myArrayBlockingQueue = new MyArrayBlockingQueue(1000);


        Thread t1 = new Thread(() -> {
            try {
                int count = 1;
                while (true) {
                    System.out.println("生产:" + count);
                    myArrayBlockingQueue.put(count + "");
                    count++;
                    //Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("消费:" + myArrayBlockingQueue.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }

        });


        t1.start();

        t2.start();
    }
}
