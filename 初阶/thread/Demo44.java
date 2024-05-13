package thread;
import java.util.concurrent.Semaphore;

public class Demo44 {

    public static void main(String[] args) throws InterruptedException {
        // 四个可用资源 P申请资源 V释放资源
        Semaphore semaphore = new Semaphore(4);

        semaphore.acquire(1);
        System.out.println("P操作");
        semaphore.acquire(1);
        System.out.println("P操作");
        semaphore.acquire(1);
        System.out.println("P操作");
        semaphore.acquire(1);
        System.out.println("P操作");

        // 此时信号量的四个资源已经被申请完了
        // 如果继续申请的话就会堵塞 因为要等别的线程释放信号量的资源
        semaphore.acquire();

    }


}
