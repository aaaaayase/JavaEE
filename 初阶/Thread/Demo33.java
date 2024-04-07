package Thread;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Demo33 {

    public static void main(String[] args) throws InterruptedException {

        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
        blockingDeque.put("aaaa");
        System.out.println(blockingDeque.take());

        System.out.println(blockingDeque.take()); //堵塞


    }

}
