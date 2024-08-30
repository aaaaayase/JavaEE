package com.yun.demo.controller;

import com.yun.demo.mapper.LogInfoMapper;
import com.yun.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/trans2")
public class TransController2 {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LogInfoMapper logInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/registry")
    public boolean registry2(String name, String password) throws IOException {
        Integer result = userInfoService.insert(name, password);
        log.info("user_info表影响行数：" + result);
        Integer logResult=logInfoMapper.insert(name,"用户注册");
        log.info("log_info表影响行数：" + result);
        return true;
    }



}
