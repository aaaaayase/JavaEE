package thread;

class Counter {
    public int count = 0;

    synchronized public void add() {
//        synchronized (this) {
//
//        }
        count++;
    }

    synchronized public static void func() {
//        synchronized (Counter.class) {
//
//        }
    }

    public int get() {
        return count;
    }
}


public class Demo24 {


    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        //Counter counter1 = new Counter();
        Thread t1 = new Thread(() -> {
//            synchronized (counter) {
//                counter.add();
//            }
            for (int i = 0; i < 5000; i++) {
                counter.add();
            }

        });

        Thread t2 = new Thread(() -> {
//           synchronized (counter) {
//               counter.add();
//           }

            //counter2.add();
            for (int i = 0; i < 5000; i++) {
                counter.add();
            }
        });


        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.get());
    }

}
