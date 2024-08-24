package com.yun.book.controller;

import com.yun.book.constant.Constants;
import com.yun.book.model.Result;
import com.yun.book.model.UserInfo;
import com.yun.book.service.UserInfoService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/login")
    public Result login(String userName, String password, HttpSession session) {
        log.info("用户登录 userName:{}, password:{}", userName, password);
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return Result.fail("用户名或密码不能为空");
        }

        UserInfo userInfo = userInfoService.selectByName(userName);
        if (userInfo == null || userInfo.getId() < 0) {
            return Result.fail("用户不存在");
        }
        if (!userInfo.getPassword().equals(password)) {
            return Result.fail("账号或密码错误");
        }


        // 设置session
        userInfo.setPassword("");
        session.setAttribute(Constants.USER_SESSION_KEY, userInfo);
        return Result.success("");

    }
}
