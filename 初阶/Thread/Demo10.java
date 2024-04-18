package Thread;

public class Demo10 {
    //这里不会出现变量捕获的情况是因为，这里单纯就是内部类使用外部类变量天经地义
    private static boolean isRunning=true;

    public static void main(String[] args) {
        //boolean isRunning=true;
        //这里不能如此使用，因为处于lambada表达式中的变量捕获的情况
        //isRunning变量必须是final或者事实final 但是后面会修改isRunning的值 因此如果这样使用编译就会报错
        Thread t=new Thread(()->{
            while (isRunning) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("线程已经终止");
        });

        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("准备终止线程");
        isRunning=false;

    }
}
