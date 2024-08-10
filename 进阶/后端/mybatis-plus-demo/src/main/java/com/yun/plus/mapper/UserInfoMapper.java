package com.yun.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yun.plus.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
