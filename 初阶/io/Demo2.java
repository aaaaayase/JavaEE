package io;

import java.io.File;
import java.io.IOException;

public class Demo2 {

    public static  void main(String[] args) throws IOException {
        File file=new File("./test.txt");

        file.createNewFile();//创建文件 如果文件存在就返回false 如果文件路径不合法就抛出异常

        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());



    }



}
