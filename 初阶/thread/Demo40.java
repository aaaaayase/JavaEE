package thread;

import java.util.PriorityQueue;
import java.util.TimerTask;

class MyTimerTask implements Comparable<MyTimerTask> {
    private Runnable runnable;
    //这里的time是绝对时间
    private long time;

    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        //绝对时间，当前时间加上需要延迟的时间长度
        this.time = System.currentTimeMillis() + delay;

    }

    public void run() {
        runnable.run();
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int) (this.time - o.time);
    }
}

class MyTimer {
    //优先级队列存储任务可以根据时间的前后来输出从而避免让线程去遍历
    PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();

    public MyTimer() {
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    //因为这里的线程修改任务队列以及schedule方法的线程也会修改队列就会出现线程安全问题，故而加锁
                    synchronized (this) {
                        //当任务队列为空的时候，线程先等着任务加入再执行
                        if (queue.size() == 0) {
                            this.wait();
                        }
                        MyTimerTask task = queue.peek();
                        long curTime = System.currentTimeMillis();
                        //达到任务开始的时间直接执行并在队列中删除任务
                        if (curTime >= task.getTime()) {
                            task.run();
                            queue.poll();
                        } else {
                            //未达到任务开始的时间线程等待从而避免执行多次循环占满cpu
                            this.wait(task.getTime()-curTime);
                        }

                    }

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
    }

    public void schedule(Runnable runnable, Long delay) {
        //两个线程修改队列故而加锁
        synchronized (this) {
            MyTimerTask task = new MyTimerTask(runnable, delay);
            queue.offer(task);
            //加入新任务后要唤醒线程
            this.notify();
        }

    }

}

public class Demo40 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(3000);
            }
        }, 3000L);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(2000);
            }
        }, 2000L);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(1000);
            }
        }, 1000L);


    }

}
