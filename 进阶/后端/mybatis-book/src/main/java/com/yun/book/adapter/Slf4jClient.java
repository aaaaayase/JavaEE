package com.yun.book.adapter;

public class Slf4jClient {
    public static void main(String[] args) {
        Slf4jApi slf4jApi1=new Log4jSlf4jAdapter(new Log4j());
        slf4jApi1.log("打印日志！！");

        Slf4jApi slf4jApi2=new LogBackSlf4jAdapter(new LogBack());
        slf4jApi2.log("打印日志！！！");
    }
}
