package Thread;

public class Demo18 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
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
        //线程状态-waiting（死等）
        t.join();

        System.out.println("main end");
    }
}
