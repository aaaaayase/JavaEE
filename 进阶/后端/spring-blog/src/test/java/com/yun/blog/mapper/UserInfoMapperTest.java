package com.yun.blog.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    UserInfoMapper mapper;

    @Test
    void selectById() {

        System.out.println(mapper.selectById(1));
    }

    @Test
    void selectByName() {
        System.out.println(mapper.selectByName("zhangsan"));
    }
}