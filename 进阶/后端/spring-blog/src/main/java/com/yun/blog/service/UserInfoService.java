package com.yun.blog.service;

import com.yun.blog.mapper.BlogInfoMapper;
import com.yun.blog.mapper.UserInfoMapper;
import com.yun.blog.model.BlogInfo;
import com.yun.blog.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    BlogInfoMapper blogInfoMapper;

    public UserInfo selectById(Integer id) {
        return userInfoMapper.selectById(id);
    }

    public UserInfo selectByName(String name) {
        return userInfoMapper.selectByName(name);
    }


    public UserInfo selectAuthorInfo(Integer blogId) {
        // 查到blog中的userid
        BlogInfo blogInfo = blogInfoMapper.selectById(blogId);
        Assert.notNull(blogInfo, "blogInfo为null");
        Integer userId = blogInfo.getUserId();
        Assert.notNull(userId, "userId为空");
        // 通过userid得到authorinfo
        UserInfo userInfo = userInfoMapper.selectById(userId);
        return userInfo;
    }
}
