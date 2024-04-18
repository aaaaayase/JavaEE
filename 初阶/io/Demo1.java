package io;

import java.io.File;
import java.io.IOException;

public class Demo1 {

    public static void main(String[] args) throws IOException {
        File file = new File("F:/test.txt"); //创建的file类对象的路径中的文件可以存在也可以不存在
        //使用绝对路径 输出标准看不出差别
        System.out.println(file.getParent());// F:/
        System.out.println(file.getPath());// F:/test.txt
        System.out.println(file.getName());// test.txt
        System.out.println(file.getAbsolutePath());// F:/test.txt
        System.out.println(file.getCanonicalPath());// F:/test.txt

        File file1 = new File("./test.txt");
        System.out.println(file1.getParent());// 这里父目录直接草率的取了。
        System.out.println(file1.getName());// 这里名字还是一样test.txt
        System.out.println(file1.getPath());// 取的是相对路径
        System.out.println(file1.getAbsolutePath());// 将工作目录和给出的相对路径进行直接拼接
        // 这里的工作目录就是当前项目所处的工作目录
        // 如果在命令行界面使用java运行 那么工作目录就是运行时的命令行的路径 例如自己在命令行运行工作目录就是C:\Users\1
        System.out.println(file1.getCanonicalPath());// 去掉上面绝对路径的那个点 就是更多的对格式进行调整


    }

}
