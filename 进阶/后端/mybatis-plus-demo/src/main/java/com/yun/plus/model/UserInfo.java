package com.yun.plus.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("Userinfo")
public class UserInfo {
    private Integer id;
    @TableField("username")
    private String userName;
    @TableField("password")
    private String pwd;
    private Integer age;
    private Date createTime;
    private Date updateTime;
}
