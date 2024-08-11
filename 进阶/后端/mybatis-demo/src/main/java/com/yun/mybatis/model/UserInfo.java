package com.yun.mybatis.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private int age;
    private Integer gender;
    private String phone;
    private int deleteFlag;
    private Date createTime;
    private Date updateTime;
}
