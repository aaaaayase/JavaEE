package com.yun.mybatis.model;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer uid;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
    //⽤⼾相关信息
    private String username;
    private Integer age;
    private Integer gender;
}
