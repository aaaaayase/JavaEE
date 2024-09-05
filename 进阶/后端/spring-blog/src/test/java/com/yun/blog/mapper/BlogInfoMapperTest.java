package com.yun.blog.mapper;

import com.yun.blog.model.BlogInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogInfoMapperTest {

    @Autowired
    BlogInfoMapper mapper;

    @Test
    void selectAll() {
        mapper.selectAll().forEach(System.out::println);
    }

    @Test
    void selectById() {
        System.out.println(mapper.selectById(1));
    }

    @Test
    void insert() {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setContent("测试");
        blogInfo.setTitle("测试");
        blogInfo.setUserId(1);
        mapper.insert(blogInfo);
    }

    @Test
    void update() {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setContent("更新");
        blogInfo.setId(1);
        mapper.update(blogInfo);
    }
}