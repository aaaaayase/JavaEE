package Thread;

public class Demo9 {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {

            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {

            }
        });

        t.start();
        t2.start();


    }


}
