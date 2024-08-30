package com.yun.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {

    @Insert("insert into user_info(user_name,password) values (#{name},#{password})")
    public Integer insert(String name, String password);

}
