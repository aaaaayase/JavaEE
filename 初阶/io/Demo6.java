package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo6 {

    public static void main(String[] args) throws IOException {
//         读文件的两种不同参数的read方法的使用
//        InputStream inputStream = new FileInputStream("F:/test.txt");
//        while (true) {
//            int b = inputStream.read();
//            if (b == -1) {
//                break;
//            }
//            System.out.printf("0x%x ", b);
//        }
//        System.out.println();

//        while (true) {
//            byte[] arrB = new byte[1024];
//            int n = inputStream.read(arrB);
//            System.out.println("n = " + n);
//            if(n==-1) {
//                //读毕 n就会返回-1
//                // 在这里首先第一次会把数组填满 后面第二次循环文件内没字节了就返回-1
//                break;
//            }
//            for (int i = 0; i < n; i++) {
//                System.out.printf("0x%x ", arrB[i]);
//
//            }
//            System.out.println();
//        }
//
//    }



        // 但是每当建立一个线程或进程 建立的PCB中的文件描述符表这个顺序表它的长度是有限的
        // 每当打开一个文件 它的长度就要加一、
        // 所以打开文件后要及时关闭
        // 所以这里联想到处理unlock()的方法 即使用try finally语句
//        InputStream inputStream = new FileInputStream("F:/test.txt");
//        try {
//            while (true) {
//                byte[] arrB = new byte[1024];
//                int n = inputStream.read(arrB);
//                System.out.println("n = " + n);
//                if (n == -1) {
//                    //读毕 n就会返回-1
//                    // 在这里首先第一次会把数组填满 后面第二次循环文件内没字节了就返回-1
//                    break;
//                }
//                for (int i = 0; i < n; i++) {
//                    System.out.printf("0x%x ", arrB[i]);
//                }
//                System.out.println();
//            }
//        } finally {
//            inputStream.close();
//        }


        // 使用try finally确实可以 但是作为一个程序员要追求去写优雅的代码
        // 上述代码修改如下
        // 直接将流对象的创建放到try右边的括号中 这样java会自动帮你调用close()
        // 注意不是什么对象都可以这样 必须要实现Closeable接口的类才可以
        try (InputStream inputStream = new FileInputStream("F:/test.txt");){
            while (true) {
                byte[] arrB = new byte[1024];
                int n = inputStream.read(arrB);
                System.out.println("n = " + n);
                if (n == -1) {
                    //读毕 n就会返回-1
                    // 在这里首先第一次会把数组填满 后面第二次循环文件内没字节了就返回-1
                    break;
                }
                for (int i = 0; i < n; i++) {
                    System.out.printf("0x%x ", arrB[i]);
                }
                System.out.println();
            }
        }

    }


}
