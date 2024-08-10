package com.yun.generator.mapper;

import com.yun.generator.model.Userinfo;
import java.util.List;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    List<Userinfo> selectAll();

    int updateByPrimaryKey(Userinfo record);
}