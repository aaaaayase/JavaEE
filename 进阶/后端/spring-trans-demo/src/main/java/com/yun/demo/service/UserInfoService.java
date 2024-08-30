package com.yun.demo.service;

import com.yun.demo.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public Integer insert(String name, String password) {
        return userInfoMapper.insert(name, password);
    }

}
