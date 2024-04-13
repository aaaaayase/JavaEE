package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyThreadPool {
    //注意细节 LinkedBlockingQueue时添加元素会自动扩容导致添加时不会堵塞 只有移除元素时可能会堵塞
    //ArrayBlocking不会自动扩容 添加和删除元素都有可能堵塞
    private ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);

    private int threadMaxSize = 0;
    private List<Thread> list = new ArrayList<>();

    // 初始化线程池
    public MyThreadPool(int coreSize, int threadMaxSize) {

        this.threadMaxSize = threadMaxSize;
        for (int i = 0; i < coreSize; i++) {
            // 创建若干个线程
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            Runnable runnable = queue.take();
                            runnable.run();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            });

            t.start();
            list.add(t);
        }

    }

    // 把任务添加到线程池中
    public void submit(Runnable runnable) throws InterruptedException {
        // 此处进行判定, 判定说当前任务队列的元素个数, 是否比较长.
        // 如果队列元素比较长, 说明已有的线程, 不太能处理过来了. 创建新的线程即可.
        // 如果队列不是很长, 没必要创建新的线程.
        queue.put(runnable);
        if (list.size() < threadMaxSize && queue.size() >= 500) {
            //创建新线程
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            Runnable task = queue.take();
                            task.run();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            t.start();
        }
    }
}

public class Demo38 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(10, 20);

        for (int i = 0; i < 10000; i++) {
            int temp = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello" + temp + "," + Thread.currentThread().getName());
                }
            });
        }

    }

}
