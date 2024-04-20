package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Demo10 {

    public static void main(String[] args) {

        try (InputStream inputStream = new FileInputStream("F:/test.txt")) {

            Scanner sc = new Scanner(inputStream);
            sc.next();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
