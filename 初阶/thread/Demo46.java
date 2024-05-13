package thread;

import java.util.concurrent.CountDownLatch;

public class Demo46 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            int temp = i;
            Thread t = new Thread(() -> {
                System.out.println("线程启动:" + temp);
                //当作任务
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程结束:" + temp);
                latch.countDown();
            });

            t.start();

        }

        //等待所有线程中的任务结束
        latch.await();
        System.out.println("所有线程结束。");

    }

}
