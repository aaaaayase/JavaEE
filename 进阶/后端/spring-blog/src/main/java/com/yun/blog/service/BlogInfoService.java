package com.yun.blog.service;

import com.yun.blog.mapper.BlogInfoMapper;
import com.yun.blog.model.BlogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogInfoService {

    @Autowired
    BlogInfoMapper mapper;

    public List<BlogInfo> selectAll() {
        return mapper.selectAll();
    }

    public BlogInfo selectById(Integer id) {
        return mapper.selectById(id);
    }

    public Integer insert(BlogInfo blogInfo) {
        return mapper.insert(blogInfo);
    }

    public Integer update(BlogInfo blogInfo) {
        return mapper.update(blogInfo);
    }
}
