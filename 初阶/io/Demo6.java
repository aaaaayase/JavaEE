package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo6 {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = new FileInputStream("F:/test.txt");

//        while (true) {
//            int b = inputStream.read();
//            if (b == -1) {
//                break;
//            }
//            System.out.printf("0x%x ", b);
//        }
//        System.out.println();

        while (true) {
            byte[] arrB = new byte[1024];
            int n = inputStream.read(arrB);
            System.out.println("n = " + n);
            if(n==-1) {
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
