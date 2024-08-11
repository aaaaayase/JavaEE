package com.yun.mybatis.controller;

import com.yun.mybatis.model.UserInfo;
import com.yun.mybatis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/queryUserInfos")
    public List<UserInfo> queryUserInfos() {
        return userInfoService.queryUserInfos();
    }
}
