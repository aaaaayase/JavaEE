package com.yun.book.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
public enum ResultCodeEnum {
    NOLOGIN(-1,"未登录"),
    SUCCESS(200,"成功"),
    FAIL(-2,"后端异常")
    ;
    @Getter
    private Integer code;
    @Getter
    private String name;

}
