package com.yun.book.adapter;

public class Log4jSlf4jAdapter implements Slf4jApi{

    private Log4j log4j;

    public Log4jSlf4jAdapter(Log4j log4j) {
        this.log4j = log4j;
    }

    @Override
    public void log(String msg) {
        log4j.print(msg);
    }
}
