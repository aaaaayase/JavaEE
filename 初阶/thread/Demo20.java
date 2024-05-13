package thread;

public class Demo20 {
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 5000; i++) {
                count++;

            }

        });

        Thread t2= new Thread(() -> {

            for (int i = 0; i < 5000; i++) {
                count++;

            }

        });

        //串行执行
//        t1.start();
//        t1.join();
//        t2.start();
//        t2.join();

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("count:"+count);

    }
}
