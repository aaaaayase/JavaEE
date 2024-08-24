package com.yun.book.service;

import com.yun.book.mapper.UserInfoMapper;
import com.yun.book.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    UserInfoMapper mapper;

    public UserInfo selectByName(String userName) {
        UserInfo userInfo = mapper.selectByName(userName);
        return userInfo;
    }
}
