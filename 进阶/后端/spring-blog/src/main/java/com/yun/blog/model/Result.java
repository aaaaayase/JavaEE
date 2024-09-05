package com.yun.blog.model;

import com.yun.blog.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class Result<T> {

    private String msg;
    private Integer code;
    private T data;

    public static <T> Result success(T data) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setData(data);
        return result;
    }

    public static <T> Result fail(String msg) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMsg(msg);
        return result;
    }

    public static <T> Result fail(String msg, Integer code) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
