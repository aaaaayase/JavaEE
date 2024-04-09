package Thread;
//class Point{
//
//    public Point(int x,int y) {
//
//    }
//
//    public Point(int r,int a) {
//
//    }
//}

//以上两个构造方法无法构成重载从而去表示笛卡尔坐标系以及极坐标系
//为了克服这种情况可以使用工厂方法来包装构造方法并且返回相应对象
//代码如下

//class Point {
//    public static Point makePointForXy() {
//        Point p = new Point();
//        p.setX();
//        p.setY();
//        return p;
//    }
//
//    public static Point makePointForRa() {
//        Point p = new Point();
//        p.setR();
//        p.setA();
//        return p;
//    }
//
//}

import java.awt.*;

//class Point {
//
//}
////专门用来包装构造方法的类就是工厂类
////代码如下
//class PointBuilder {
//    public static Point makePointForXy() {
//        Point p = new Point();
//        p.setX();
//        p.setY();
//        return p;
//    }
//    public static Point makePointForRa() {
//        Point p = new Point();
//        p.setR();
//        p.setA();
//        return p;
//    }
//
//}

public class Demo36 {
    //Point p = PointBuilder.makePointForRa(10, 20);
}
