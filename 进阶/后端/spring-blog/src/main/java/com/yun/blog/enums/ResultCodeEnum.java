package com.yun.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ResultCodeEnum {
    SUCCESS(200),
    FAIL(-1),
    NO_LOGIN(-2),
    PARAM_INVALID(-3),
    NO_RESOURCES(-4);
    @Getter
    private Integer code;
}
