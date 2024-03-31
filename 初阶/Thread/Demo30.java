package Thread;

public class Demo30 {

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Object locker1 = new Object();
        Thread t1 = new Thread(() -> {

            synchronized (locker) {
                System.out.println("t1等待之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t1等待之后");

            }

        });

        Thread t2 = new Thread(() -> {
            synchronized (locker1) {
                System.out.println("t2等待之前");
                try {
                    locker1.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t2等待之后");
            }


        });


        Thread t3 = new Thread(() -> {
            synchronized (locker) {
                //locker.notifyAll();
                locker.notify();
            }

            synchronized (locker1) {
                locker1.notify();
            }


        });


        t1.start();
        t2.start();

        Thread.sleep(1000);
        t3.start();

    }

}
