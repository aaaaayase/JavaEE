package Thread;

public class Demo18 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            while (true) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
           
        });

        t.start();
        //线程状态-WAITING（死等）
        t.join();

    }
}
