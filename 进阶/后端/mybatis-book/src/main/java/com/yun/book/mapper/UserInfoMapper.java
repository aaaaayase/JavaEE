package com.yun.book.mapper;

import com.yun.book.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    @Select("select *from user_info where delete_flag=0 and user_name= #{userName}")
    public UserInfo selectByName(String userName);

}
