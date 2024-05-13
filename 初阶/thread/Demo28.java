package thread;

import java.util.Scanner;

public class Demo28 {

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Scanner scanner = new Scanner(System.in);
        System.out.println("等待之前");
        //wait必须在synchronized内使用，会解锁并且让线程进入阻塞等待状态
        synchronized (locker) {
            locker.wait();
        }

        System.out.println("等待之后");

    }
}
