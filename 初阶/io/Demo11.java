package io;

import java.io.File;
import java.util.Scanner;

public class Demo11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("输入要查找文件的目录：");
        String dirPath = sc.nextLine();
        System.out.println("输入要查找文件的关键词：");
        String keyWord = sc.nextLine();

        // 根据输入的路径构造file对象
        File dir = new File(dirPath);

        // 如果输入的路径不是目录则直接返回并报错
        if (!dir.isDirectory()) {
            System.out.println("输入路径非法！");
            return;
        }

        // 关键词和目录都是正确的那么就开始查找文件
        searchFile(dir, keyWord);

    }

    private static void searchFile(File dir, String keyWord) {
        // 将目录下的所有文件输出成数组
        File[] files = dir.listFiles();

        // 如果数组为空直接返回 这也是递归结束的条件
        if (files == null) {
            return;
        }

        // 遍历数组
        for (File file : files) {
            // 如果文件是文件 那么判断是否包含关键词
            if (file.isFile()) {
                // 包含则匹配成功
                if (file.getName().contains(keyWord)) {

                    System.out.println("匹配成功：" + file.getAbsoluteFile());
                }
                // 如果是目录则进行递归 在下一级目录进行查找
            } else if (file.isDirectory()) {

                searchFile(file, keyWord);

            }


        }


    }
}
