package com.yun.book.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StatusEnum {

    DELETED(0, "无效"),
    NORMAL(1, "可借阅"),
    FORBIDDEN(2, "不可借阅");
    @Getter
    private int code;
    @Getter
    private String name;


    public static StatusEnum getNameByCode(int code) {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getCode() == code) {
                return statusEnum;
            }
        }

        return null;
    }
}
