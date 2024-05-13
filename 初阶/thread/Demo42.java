package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo42 {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //使用Runnable来求出1~100的和
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int result = 0;
                for (int i = 1; i <= 100; i++) {
                    result += i;
                }
                //需要用成员变量来接收值 主线程和t线程的耦合程度高 如果有多个这样的线程就不方便了
                count = result;
            }
        });

        // t.start();
        // t.join();
        // System.out.println(count);

        // Callable和Runnable很相似 但是Runnable可以返回计算的值
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 1; i <= 100; i++) {
                    result += i;
                }
                return result;
            }
        };

        // futuretask这个类用来包装callable这个类 这样callable就可以直接放入线程
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t2 = new Thread(futureTask);
        t2.start();
        //从future获取线程启动通过callable计算得到的值
        t2.join();
        System.out.println(futureTask.get());
    }

}
