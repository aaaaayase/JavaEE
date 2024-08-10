package com.yun.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yun.plus.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void select() {
        System.out.println(userInfoMapper.selectList(null));
    }

    @Test
    public void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUserName("jjj");
        userInfoMapper.updateById(userInfo);
    }

    @Test
    public void delete() {
        UserInfo userinfo = new UserInfo();
        userinfo.setId(1);
        userInfoMapper.deleteById(userinfo);
    }

    @Test
    public void insert() {
        UserInfo userinfo = new UserInfo();
        userinfo.setUserName("plus");
        userinfo.setPwd("sda");
        userinfo.setAge(11);
        userInfoMapper.insert(userinfo);
    }

    @Test
    public void selectByWrapper() {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.select("username", "password", "age").eq("gender", 1);
        userInfoMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    public void updateByWrapper() {
        UpdateWrapper<UserInfo> wrapper = new UpdateWrapper<>();
        wrapper.set("username", "ccc").set("age", 5).in("id", List.of(1, 2, 34, 5, 6, 7, 78, 9, 10));
        userInfoMapper.update(wrapper);
    }
}