package io;

import java.io.File;

public class Demo4 {

    public static void main(String[] args) {
        File file=new File("./testDir");
        // 创建单级目录
        //file.mkdir(); //创建成功返回true 已经存在创建失败返回false

        File file2=new File("./testDir/aaa/bbb/ccc");
        // 创建多级目录
        file2.mkdirs();

        System.out.println(file.isDirectory());
    }
}
