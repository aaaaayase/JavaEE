package com.yun.blog.controller;

import com.yun.blog.enums.ResultCodeEnum;
import com.yun.blog.model.BlogInfo;
import com.yun.blog.model.Result;
import com.yun.blog.service.BlogInfoService;
import com.yun.blog.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogInfoController {
    @Autowired
    BlogInfoService service;

    @RequestMapping("/getBlogList")
    public List<BlogInfo> getBlogList() {
        return service.selectAll();
    }

    @RequestMapping("/getBlogDetail")
    public BlogInfo getBlogById(Integer blogId, HttpServletRequest request) {
        if (blogId == null) {
            throw new UnsupportedOperationException("id不能为null");
        }
        BlogInfo blogInfo = service.selectById(blogId);
        Integer authorId = blogInfo.getUserId();
        String token = request.getHeader("user_token_header");
        Integer userId = JwtUtils.getJwtUserId(token);

        if (authorId != null && authorId == userId) {
            blogInfo.setIsLoginUser(true);
        }

        return blogInfo;

    }

    @RequestMapping("/add")
    public boolean addBlog(@Validated @RequestBody BlogInfo blogInfo, HttpServletRequest request) {
        String token = request.getHeader("user_token_header");
        log.info("从header中获取到信息，token:" + token);
        Integer userId = JwtUtils.getJwtUserId(token);
        blogInfo.setUserId(userId);
        Integer result = null;
        try {
            result = service.insert(blogInfo);
            if (result == 1) {
                return true;
            }
        } catch (Exception e) {
            log.error("发布博客失败");
        }
        return false;
    }

    @RequestMapping("/update")
    public boolean update(@Validated @RequestBody BlogInfo blogInfo) {
        Integer result = null;
        try {
            result = service.update(blogInfo);
            if (result >= 1) {
                return true;
            }
        } catch (Exception e) {
            log.error("updateBlog 发生异常, e: ", e);
        }

        return false;

    }

    @RequestMapping("/delete")
    public boolean delete(Integer blogId) {
        Integer result = null;
        try {
            BlogInfo blogInfo = new BlogInfo();
            blogInfo.setId(blogId);
            blogInfo.setDeleteFlag(1);
            result = service.update(blogInfo);
            if (result >= 1) {
                return true;
            }
        } catch (Exception e) {
            log.error("deleteBlog 发生异常, e: ", e);
        }

        return false;
    }

}
