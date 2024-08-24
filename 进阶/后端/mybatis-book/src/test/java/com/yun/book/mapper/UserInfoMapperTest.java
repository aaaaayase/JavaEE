package com.yun.book.mapper;

import com.yun.book.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    UserInfoMapper mapper;

    @Test
    void selectByName() {
        UserInfo userInfo=mapper.selectByName("zhangsan");
        System.out.println(userInfo);
    }
}