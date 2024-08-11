package com.yun.mybatis.mapper;

import com.yun.mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoXMLMapperTest {

    @Autowired
    UserInfoXMLMapper userInfoXMLMapper;

    @Test
    void queryAllUser() {
        System.out.println(userInfoXMLMapper.queryAllUser());
    }

    @Test
    void queryAllUser2() {
        userInfoXMLMapper.queryAllUser2().forEach(System.out::println);
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("ddd");
        userInfo.setPassword("111111");
        userInfo.setAge(11);
        userInfo.setGender(1);
        userInfo.setPhone("123232131");
        System.out.println(userInfoXMLMapper.insertUser(userInfo));
    }

    @Test
    void deleteUserById() {
        System.out.println(userInfoXMLMapper.deleteUserById(12));
    }

    @Test
    void updateUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("yyy");
        userInfo.setAge(11);
        System.out.println(userInfoXMLMapper.updateUser(userInfo));
    }

    @Test
    void queryForTables() {
        System.out.println(userInfoXMLMapper.queryForTables(1));
    }


    @Test
    void insertUserDynamic() {
        UserInfo userInfo = new UserInfo();
        // userInfo.setUserName("dsa");
        userInfo.setAge(11);
        userInfo.setPhone("123123");
        userInfo.setGender(1);
        userInfo.setPassword("123123");

        userInfoXMLMapper.insertUserDynamic(userInfo);
    }

    @Test
    void insertUserDynamic2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("aaa");
        userInfo.setAge(11);
        //userInfo.setPhone("123123");
        userInfo.setGender(1);
        userInfo.setPassword("123123");

        userInfoXMLMapper.insertUserDynamic2(userInfo);
    }

    @Test
    void selectUserDynamic() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(11);
        //userInfo.setPhone("123123");
        userInfo.setPassword("123123");
        userInfoXMLMapper.selectUserDynamic(userInfo).forEach(System.out::println);
    }

    @Test
    void deleteDynamic() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(0);
        //userInfo.setPhone("123123");
        userInfo.setPassword("0");
        userInfoXMLMapper.deleteDynamic(userInfo);
    }

    @Test
    void updateDynamic() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(0);
        //userInfo.setPhone("123123");
        userInfo.setPassword("0");
        userInfo.setUserName("yyy");
        userInfoXMLMapper.updateDynamic(userInfo);
    }

    @Test
    void selectUserDynamic2() {
        userInfoXMLMapper.selectUserDynamic2(List.of(1,2,3,4,5,6,7)).forEach(System.out::println);
    }
}