package Thread;

import java.util.Scanner;

public class Demo29 {
    public static void main(String[] args) throws InterruptedException {

        Object locker = new Object();
        //1.wait和notify必须都在synchronized内
        //2.一个notify唤醒一个wait() 如果多个线程wait就使用多个notify或者notifyAll 这种唤醒时随机的
        //3.如果想唤醒指定线程也可以必须一对一写好锁对象
        //4.notify需要在wait之后

        Thread t1=new Thread(()->{
            System.out.println("t1 等待之前");
            synchronized (locker) {
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("t1 等待之后");


        });


        Thread t2=new Thread(()->{
            System.out.println("t2 通知之前");
            Scanner scanner=new Scanner(System.in);
            //控制阻塞，不输入数字t1仍是阻塞
            scanner.nextInt();
            synchronized (locker) {

                locker.notify();
            }
            System.out.println("t2 通知之后");
        });

        t2.start();
        t1.start();




    }

}
