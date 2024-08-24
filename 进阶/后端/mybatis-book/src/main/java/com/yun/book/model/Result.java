package com.yun.book.model;

import com.yun.book.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class Result<T> {

    private ResultCodeEnum code;
    private String msg;
    private T data;

    public static <T> Result<T> noLogin() {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.NOLOGIN);
        result.setMsg("用户未登录！！！");
        result.setData(null);

        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setMsg("成功！！！");
        result.setData(data);

        return result;
    }

    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.FAIL);
        result.setMsg(msg);
        result.setData(null);

        return result;
    }

}
