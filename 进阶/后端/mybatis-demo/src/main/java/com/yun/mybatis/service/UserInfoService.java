package com.yun.mybatis.service;


import com.yun.mybatis.mapper.UserInfoMapper;
import com.yun.mybatis.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> queryUserInfos() {

        return userInfoMapper.queryUserInfos();
    }
}
