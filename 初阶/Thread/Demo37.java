package Thread;

import java.util.concurrent.*;

public class Demo37 {
    public static void main(String[] args) throws InterruptedException {
        //线程池中的线程是前台线程

        //以下线程池都是通过java标准库提供的工厂类Executors建立的
        //相较于ThreadPoolExecutor类来建立线程池参数少相对的就没有ThreadPoolExecutor精细
        //Executors.newCachedThreadPool();
        //创建普通的线程池，根据任务的数目来对线程扩容
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            int temp = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello" + temp + "," + Thread.currentThread().getName());
                }
            });
        }


        //Executors.newFixedThreadPool(10);
        //创建固定线程数的线程池，线程数既不能增加也不能减少。这里设置的是最大线程数

        //Executors.newScheduledThreadPool()；
        //创建固定线程数的线程池，但是任务延时执行


        //Executors.newSingleThreadExecutor();
        //创建包含单个线程的线程池
    }

}
