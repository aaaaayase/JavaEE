package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo8 {
    public static void main(String[] args) {

        try (Reader reader = new FileReader("F:/test.txt")) {
            while (true) {
                int n = reader.read();
                if(n==-1) {
                    break;
                }

                System.out.printf("%c ",n);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
