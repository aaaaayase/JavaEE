package thread;

import java.util.Random;

public class Demo21 {
    //给定一个很长的数组 (长度 1000w), 通过随机数的方式生成 1-100 之间的整数.
    //实现代码, 能够创建两个线程, 对这个数组的所有元素求和.
    //其中线程1 计算偶数下标元素的和, 线程2 计算奇数下标元素的和.
    //最终再汇总两个和, 进行相加
    //记录程序的执行时间

    static long sum1 = 0;
    static long sum2 = 0;

    public static void main(String[] args) throws InterruptedException {
        long begin=System.currentTimeMillis();

        int total=1000_0000;
        int[] arr = new int[total];

        Random random=new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(100)+1;
        }

        long end=System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i=0; i < arr.length; i += 2) {
                sum1 += arr[i];
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i=1; i < arr.length; i += 2) {
                sum2 += arr[i];
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum1+sum2);
        System.out.println(end-begin);


    }


}
