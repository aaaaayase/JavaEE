package com.yun.blog.config;

import com.yun.blog.enums.ResultCodeEnum;
import com.yun.blog.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler
    public Result handler(Exception e) {
        log.error("发生异常，e:", e);
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler
    public Result handler(UnsupportedOperationException e) {
        log.error("发生异常，e:", e.getMessage());
        return Result.fail(e.getMessage(), ResultCodeEnum.PARAM_INVALID.getCode());
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public Result handler(NoResourceFoundException e) {
        log.error("文件不存在，e", e.getMessage());
        return Result.fail(e.getMessage(), ResultCodeEnum.NO_RESOURCES.getCode());
    }

    @ExceptionHandler
    public Result handler(MethodArgumentNotValidException e) {
        log.error("参数校验不通过，e", e.getMessage());
        return Result.fail(e.getMessage(), ResultCodeEnum.PARAM_INVALID.getCode());
    }

}
