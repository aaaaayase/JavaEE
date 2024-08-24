package com.yun.book.adapter;

public class LogBackSlf4jAdapter implements Slf4jApi {

    private LogBack logBack;

    public LogBackSlf4jAdapter(LogBack logBack) {
        this.logBack = logBack;
    }

    @Override
    public void log(String msg) {
        logBack.out(msg);
    }
}
