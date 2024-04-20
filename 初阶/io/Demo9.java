package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo9 {

    public static void main(String[] args) {
        try (Writer writer = new FileWriter("F:/test.txt")) {
            // 字符流写文件和字节流一样 都是要加上一个true这个参数才能实现append这样的效果
            writer.write("你好世界");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
