package io;

import java.io.*;
import java.util.Scanner;

public class Demo13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入目标目录：");
        String dirPath = sc.nextLine();
        System.out.println("请输入要匹配的关键词：");
        String keyWord = sc.nextLine();

        File dirFile = new File(dirPath);

        if (!dirFile.isDirectory()) {
            System.out.println("输入路径不合法！！");
            return;
        }

        search(dirFile, keyWord);

    }

    private static void search(File dirFile, String keyWord) {
        File[] files = dirFile.listFiles();

        if (files == null) {

            return;
        }

        for (File f :
                files) {
            if (f.isFile()) {

                match(f, keyWord);
            } else if (f.isDirectory()) {

                search(f, keyWord);
            }
        }


    }

    private static void match(File f, String keyWord) {
        StringBuilder stringBuilder = new StringBuilder();
        try (Reader reader = new FileReader(f)) {
            while (true) {
                int b = reader.read();
                if (b == -1) {
                    break;
                }

                stringBuilder.append((char) b);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (stringBuilder.indexOf(keyWord) >= 0) {

            System.out.println("匹配成功：" + f.getAbsolutePath());
        }

    }


}
