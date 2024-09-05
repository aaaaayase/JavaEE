package com.yun.blog.controller;

import com.yun.blog.enums.ResultCodeEnum;
import com.yun.blog.model.Result;
import com.yun.blog.model.UserInfo;
import com.yun.blog.service.UserInfoService;
import com.yun.blog.utils.JwtUtils;
import com.yun.blog.utils.SecurityUtils;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/login")
    public Result login(String name, String password) {
        if (!StringUtils.hasLength(name) || !StringUtils.hasLength(password)) {
            return Result.fail("密码或用户名为空", ResultCodeEnum.PARAM_INVALID.getCode());
        }
        UserInfo userInfo = userInfoService.selectByName(name);
        if (userInfo == null || userInfo.getId() == null) {
            return Result.fail("用户不存在", ResultCodeEnum.PARAM_INVALID.getCode());
        }
//        if (!password.equals(userInfo.getPassword())) {
//            return Result.fail("密码错误", ResultCodeEnum.PARAM_INVALID.getCode());
//        }
        if (!SecurityUtils.verify(password, userInfo.getPassword())) {
            log.error("密码验证失败");
            return Result.fail("密码错误", ResultCodeEnum.PARAM_INVALID.getCode());
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", userInfo.getId());
        claims.put("name", userInfo.getUserName());

        String jwt = JwtUtils.genJwt(claims);
        return Result.success(jwt);
    }

    @RequestMapping("/getUserInfo")
    public UserInfo getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("user_token_header");
        Integer id = JwtUtils.getJwtUserId(token);
        Assert.notNull(id, "id为null");
        return userInfoService.selectById(id);
    }

    @RequestMapping("/getAuthorInfo")
    public UserInfo getAuthorInfo(Integer blogId) {
        Assert.notNull(blogId, "blogId不为null");
        return userInfoService.selectAuthorInfo(blogId);
    }

}
