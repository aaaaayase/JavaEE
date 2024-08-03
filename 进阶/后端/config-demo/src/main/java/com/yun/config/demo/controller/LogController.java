package com.yun.config.demo.controller;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // lombok提供的注解 可以直接使用log对象
@RequestMapping("/log")
@RestController
public class LogController {

    // private static Logger logger = LoggerFactory.getLogger(LogController.class);

    @PostConstruct
    public void output() {
        System.out.println("打印日志");
        log.trace("trace日志"); // trace以及debug日志不打印 因为idea默认是info级别的 级别太低直接忽略
        log.debug("debug日志");
        log.info("info日志");
        log.warn("warn日志");
        log.error("error日志");
        // 至于fatal日志没有这个方法 因为此时错误已经无法挽回 不需要提醒了

    }
}
