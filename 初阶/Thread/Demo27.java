package Thread;

import java.util.Scanner;

public class Demo27 {
    private volatile static int count=0;
    //下面这段代码会出现内存的可见性问题
    //将从内存中读取count值的操作称为load 判断操作称为cmp
    //load和cmp的执行速度差了好几个数量级，在线程2开始执行代码提示输入数字时，线程1的while循环已经执行了很多遍
    //java编译器会自动给代码进行优化
    //导致load只是第一次时真正从内存中读取count值，其余都是从cpu的寄存器中读取
    //然而线程2修改count是在内存中进行修改，线程1根本访问不到count的值
    //可以在变量前加上volatile关键字来提醒编译器不要优化
    public static void main(String[] args) {

        Thread t=new Thread(()->{

            while(count==0) {
                //
            }
            System.out.println("t1 执行结束");
        });

        Thread t2=new Thread(()->{
            Scanner scanner=new Scanner(System.in);
            System.out.println("输入数字：");

            count=scanner.nextInt();
        });


        t.start();
        t2.start();

    }

}
