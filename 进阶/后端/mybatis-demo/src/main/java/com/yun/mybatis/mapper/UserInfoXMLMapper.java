package com.yun.mybatis.mapper;

import com.yun.mybatis.model.ArticleInfo;
import com.yun.mybatis.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoXMLMapper {

    public List<UserInfo> queryAllUser();

    public List<UserInfo> queryAllUser2();

    public Integer insertUser(UserInfo userInfo);

    public Integer deleteUserById(Integer id);

    public Integer updateUser(UserInfo userInfo);

    // 多表查询
    public ArticleInfo queryForTables(Integer id);

    // 动态sql
    public Integer insertUserDynamic(UserInfo userInfo);

    public Integer insertUserDynamic2(UserInfo userInfo);

    public List<UserInfo> selectUserDynamic(UserInfo userInfo);

    public List<UserInfo> selectUserDynamic2(List<Integer> ids);

    public Integer deleteDynamic(UserInfo userInfo);

    public Integer updateDynamic(UserInfo userInfo);


}
