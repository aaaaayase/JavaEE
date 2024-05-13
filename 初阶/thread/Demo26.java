package thread;

public class Demo26 {

    public static void main(String[] args) throws InterruptedException {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (locker2) {
                    System.out.println("t1 获取了两把锁");
                }
            }

        });

        Thread t2 = new Thread(() -> {
            synchronized (locker2) {

                synchronized (locker1) {
                    System.out.println("t2 获取了两把锁");
                }
            }
        });
        //以上代码会发生线程死锁的情况二
        //可以通过修改代码结构来避免死锁
        //避免循环等待：约定加锁的顺序
        //Thread t1 = new Thread(() -> {
        //            synchronized (locker1) {
        //                try {
        //                    Thread.sleep(1000);
        //                } catch (InterruptedException e) {
        //                    throw new RuntimeException(e);
        //                }
        //                synchronized (locker2) {
        //                    System.out.println("t1 获取了两把锁");
        //                }
        //            }
        //
        //        });
        //
        //        Thread t2 = new Thread(() -> {
        //            synchronized (locker1) {
        //
        //                synchronized (locker2) {
        //                    System.out.println("t2 获取了两把锁");
        //                }
        //            }
        //        });

        //避免请求和保持：
        //Thread t1 = new Thread(() -> {
        //            synchronized (locker1) {
        //                try {
        //                    Thread.sleep(1000);
        //                } catch (InterruptedException e) {
        //                    throw new RuntimeException(e);
        //                }
        //
        //            }
    //               synchronized (locker2) {
//                         System.out.println("t1 获取了两把锁");
        //            }
        //        });
        //
        //        Thread t2 = new Thread(() -> {
        //            synchronized (locker2) {
        //
        //
        //            }
        //        synchronized (locker1) {
        //                 System.out.println("t2 获取了两把锁");
        //         }
        //        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();


    }
}
