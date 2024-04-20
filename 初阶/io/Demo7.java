package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo7 {

    public static void main(String[] args) {

        try (OutputStream outputStream = new FileOutputStream("F:/test.txt",true)) {
            // 注意这里打开文件会发现文件内原本的内容被清空 里面全是新添加的内容
            // 这里的清空操作是打开文件时清空的，即构造对象时清空的
            // 要是想在文件内追加即append内容 只需在构造对象时将第二个参数设为true
            outputStream.write(97);
            outputStream.write(98);
            outputStream.write(98);
            outputStream.write(99);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
