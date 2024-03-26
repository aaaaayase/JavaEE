package Thread;

public class Demo19 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()-> {
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
        //带有时间的死等
        t.join(3600*1000);


    }
}
