package Thread;

public class Demo13 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("t");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });


        Thread t2=new Thread(()->{

            try {
                Thread.sleep(500);
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (int i = 0; i < 3; i++) {
                System.out.println("t2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        t.start();
        t2.start();

        t2.join();

        System.out.println("main end");

    }
}
