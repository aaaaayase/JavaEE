package com.yun.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yun.blog.utils.DateUtils;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class BlogInfo {

    private Integer id;
    @NotBlank(message = "title不能为空")
    private String title;
    @NotBlank(message = "content不能为空")
    private String content;
    private Integer userId;
    private Integer deleteFlag;
    private Date createTime;
    private Boolean isLoginUser;
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public String getUpdateTime() {
        return DateUtils.format(updateTime);
    }

}
