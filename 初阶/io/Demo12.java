package io;

import java.io.*;
import java.util.Scanner;

public class Demo12 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("输入要复制的文件路径:");
        String srcPath = sc.nextLine();
        System.out.println("输入要复制到的文件路径");
        String destPath = sc.nextLine();

        File fileSrc = new File(srcPath);
        File fileDest = new File(destPath);

        if (!fileSrc.isFile()) {
            System.out.println("输入的要复制的文件路径不合法！");
            return;
        }
        if (!fileDest.getParentFile().isDirectory()) {
            System.out.println("输入的复制到的文件路径不合法！");
            return;
        }


        byte[] bytes = new byte[1024];
        // OutPutStream会自动创建文件
        try (InputStream inputStream = new FileInputStream(fileSrc);
             OutputStream outputStream = new FileOutputStream(fileDest)) {
            while (true) {
                int n = inputStream.read(bytes);
                if (n == -1) {
                    break;
                }
                outputStream.write(bytes, 0, n);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
