package com.yun.demo.controller;

import com.yun.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/trans")
public class TransController {

    @Autowired
    private UserInfoService userInfoService;

    @Transactional(rollbackFor = Exception.class)
    // 运行时异常回滚
    // 非运行时异常照样提交
    // 可以通过属性来指定回滚的范围
    // 当你在代码中catch住异常就可以提交不会回滚
    @RequestMapping("/registry2")
    public boolean registry2(String name, String password) throws IOException {
        Integer result = userInfoService.insert(name, password);
        log.info("影响行数：" + result);
        if (true) {
            throw new IOException();
        }
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/registry3")
    public boolean registry3(String name, String password) throws IOException {
        Integer result = userInfoService.insert(name, password);
        log.info("影响行数：" + result);

        try {
            int n = 10 / 0;
        } catch (Exception e) {
            // 会回滚
            // throw new RuntimeException(e);
            // 手动设置回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return true;
    }

}
