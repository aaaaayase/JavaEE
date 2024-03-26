package Thread;

public class Demo17 {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


            System.out.println("Thread end");

        });
        System.out.println(t.getState()); //NEW thread对象有了，但还未使用start建立线程
        t.start();
        t.join();
        System.out.println(t.getState()); //TERMINATED 线程已经终止还未销毁thread对象
    }
}
