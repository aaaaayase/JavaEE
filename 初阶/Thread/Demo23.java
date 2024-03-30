package Thread;

public class Demo23 {
    public static int count=0;

    public static void main(String[] args) throws InterruptedException {
        Object object=new Object();

        Thread t1=new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                synchronized (object) {
                    count++;
                }
            }
        });

        Thread t2=new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                synchronized (object) {
                    count++;
                }
            }
        });

        t1.start();;
        t2.start();;

        t1.join();
        t2.join();


        System.out.println(count);
    }
}
