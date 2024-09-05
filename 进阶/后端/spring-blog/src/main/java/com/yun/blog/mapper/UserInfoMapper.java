package com.yun.blog.mapper;

import com.yun.blog.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;

@Mapper
public interface UserInfoMapper {

    @Select("select id,user_name,github_url from user where id=#{id} and delete_flag=0")
    public UserInfo selectById(Integer id);

    @Select("select id,user_name,password,github_url from user where user_name=#{name} and delete_flag=0")
    public UserInfo selectByName(String name);
}
