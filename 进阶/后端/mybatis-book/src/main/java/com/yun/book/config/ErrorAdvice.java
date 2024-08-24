package com.yun.book.config;

import com.yun.book.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Slf4j
@ControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler
    public Result handler(Exception e) {
        log.error("发生异常，e:", e);
        return Result.fail(e.getMessage());
    }


}
