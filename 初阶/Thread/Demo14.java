package Thread;

public class Demo14 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = Thread.currentThread();
        System.out.println(t.getName());


        Thread t2 = new Thread(() -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("hello thread");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("thread end");
        });

        t.start();

        for (int i = 0; i < 3; i++) {
            System.out.println("hello main");

            Thread.sleep(1000);
        }

        System.out.println("main end");
    }
}
