package thread;


import java.util.concurrent.ArrayBlockingQueue;


public class Demo33 {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        blockingQueue.put("aaaa");
        System.out.println(blockingQueue.take());

        System.out.println(blockingQueue.take()); //堵塞

        


    }

}
