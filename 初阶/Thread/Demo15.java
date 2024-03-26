package Thread;

public class Demo15 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {

            for (int i = 0; i < 2; i++) {
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

        t.join(3000);

        System.out.println("main end");
    }

}
