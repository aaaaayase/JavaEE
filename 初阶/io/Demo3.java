package io;

import java.io.File;
import java.util.Scanner;

public class Demo3 {

    public static void main(String[] args) {

        File file =new File("./test.txt");
        Scanner in=new Scanner(System.in);
        //删除文件
        //file.delete();

        //在线程结束时删除文件
        //在编写word文档时会自动添加一个隐藏文档来记录修改 当叉掉word文档时这个文件就会删除
        // 这个文档适用于突发状况例如电脑掉电也不会丢失修改内容
        file.deleteOnExit();
        in.next();


        System.out.println(file.exists());

    }
}
