package Thread;

class Counter1 {
    private int count = 0;

    synchronized public void add() {
        count++;
    }

    public int get() {
        return count;
    }

}

public class Demo25 {
    public static void main(String[] args) throws InterruptedException {
        Counter1 counter=new Counter1();
        Thread t1=new Thread(()->{
            for (int i = 0; i < 50000; i++) {
               //相当于
//                synchronized (counter) {
//                    synchronized (counter) {
//                        count++;
//                    }
//                }
                //按理说这样写应该会阻塞，因为外括号已经在counter上加了锁，内括号再加就会堵塞
                //内等待外执行完但是外又在等内执行完，于是进入死锁
                //但是java中不会这样，因为如果在java中内外是一个锁对象则直接进入
                //理论上上这是线程死锁的情况一
                synchronized (counter) {
                    counter.add();
                }

            }

        });

        Thread t2=new Thread(()->{

            for (int i = 0; i < 50000; i++) {
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
