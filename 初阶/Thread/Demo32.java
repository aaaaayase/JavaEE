package Thread;

//单例模式-懒汉模式
//在多线程的情况下是不安全的
class Singleton1 {

    public static Object locker = new Object();
    public static Singleton1 instance = null;

    public static Singleton1 getInstance() {

        if (instance == null) { //避免已经建立了对象重新上锁浪费性能，直接返回对象即可
            synchronized (locker) {
                if (instance == null) { //避免在多线程情况下重复创建对象，造成线程安全问题
                    instance = new Singleton1();
                }
            }
        }

        return instance;
    }

    private Singleton1() {

    }
}

public class Demo32 {

    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = Singleton1.getInstance();


        System.out.println(s1 == s2);

    }
}
