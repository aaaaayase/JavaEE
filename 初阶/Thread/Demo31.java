package Thread;

//单例模式-饿汉模式
//饿汉模式在多线程的情况下是安全的
//因为饿汉模式只会构成多线程读取一个变量的情况
class Singleton {
    public static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    private Singleton() {


    }
}

public class Demo31 {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);


    }
}
