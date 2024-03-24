package Thread;

public class Demo11 {

    //使用这种方法控制线程终止对比布尔类型变量的优势在于
    //如果Thread匿名类中的sleep时间很长，当你修改了布尔类型变量后还要等一段时间才能终止线程
    //但是使用Thread类中自带方法不需如此

    public static void main(String[] args) {
        Thread t=new Thread(()->{
            while (!Thread.currentThread().isInterrupted())
                System.out.println("hello Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
                //通过interrupt方法会修改循环条件的布尔值从而终止线程
                //之后唤醒sleep的线程，之后的处理由线程自己决定，如果catch中不终止线程，那么下一轮循环线程还是会执行
                //因为sleep会修改循环条件
                //catch里面写break；直接终止
                //或者写一些代码再终止等等
            }

        });

        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        t.interrupt();
    }
}
