package thread;

public class Demo7 {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t.setDaemon(true);

        t.start();

    }
}
