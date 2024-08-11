package com.yun.mybatis.mapper;

import com.yun.mybatis.model.UserInfo;
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
    void queryAllUser() {
        userInfoMapper.queryUserInfos().forEach(System.out::println);
    }

    @Test
    void queryUserInfos2() {
        userInfoMapper.queryUserInfos2().forEach(System.out::println);
    }

    @Test
    void queryUserInfos3() {
        userInfoMapper.queryUserInfos3();
    }

    @Test
    void queryUserInfo5() {
        userInfoMapper.queryUserInfo5(1);
    }

    @Test
    void queryUserInfo6() {
        System.out.println(userInfoMapper.queryUserInfo6(1, "admin"));
    }

    @Test
    void queryUserInfo7() {
        System.out.println(userInfoMapper.queryUserInfo7(1, "admin"));
    }

    @Test
    void queryUserInfo8() {
        System.out.println(userInfoMapper.queryUserInfo8(1, "admin"));
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("dcy");
        userInfo.setAge(11);
        userInfo.setGender(1);
        userInfo.setPhone("123412312");
        userInfo.setPassword("12344");

        userInfoMapper.insert(userInfo);
    }

    @Test
    void insert2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("dcy");
        userInfo.setAge(11);
        userInfo.setGender(1);
        userInfo.setPhone("123412312");
        userInfo.setPassword("12344");
        Integer x = userInfoMapper.insert2(userInfo);
        System.out.println(x);
        System.out.println("自增id" + userInfo.getId());

    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(10);
        userInfo.setUserName("yyy");
        userInfoMapper.update(userInfo);
    }

    @Test
    void delete() {
        userInfoMapper.delete(11);
    }
}