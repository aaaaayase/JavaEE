package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo43 {

    public static void main(String[] args) {
        // ReentrantLock锁存在的意义
        // 1.可以实现公平锁
        // 2.可以使用trylock用于获取锁，如果锁已经被获取，那么就直接返回不会去等待 还有一个版本可以设置阻塞等待的时间
        // 3.wait以及notify是用于synchronized的等待通知机制，但是notify的只能随机唤醒一个线程  ReentrantLock是通过Condition来完成等待通知机制，可以指定唤醒的线程
        ReentrantLock locker = new ReentrantLock(true);
        //这里的unlock很可能被忘记 可以使用try finally解决
        //或者这里满足条件提前返回从而执行不到unlock()
        //或者就直接抛出异常
        //if (Condition) {
        //   return;
        //}
        // throw new Exception()
        try {
            locker.lock();
        } finally {

            locker.unlock();
        }


    }
}
