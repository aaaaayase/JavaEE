package com.yun.book.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserInfo {
   private Integer id;
    private String userName;
    private String password;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
