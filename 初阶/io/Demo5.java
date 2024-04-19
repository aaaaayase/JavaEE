package io;

import java.io.File;

public class Demo5 {


    public static void main(String[] args) {
        File file1=new File("./test2.txt");
        //不仅能可以重命名文件 还可以挪动文件到文件夹下面
        File file2=new File("./testDir/test2.txt");


        file1.renameTo(file2);
    }
}
