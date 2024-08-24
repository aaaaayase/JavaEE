package com.yun.book.controller;

import com.yun.book.model.BookInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/t1")
    public String t1() {
        return "t1";
    }

    @RequestMapping("/t2")
    public Integer t2() {
        int a = 10 / 0;
        return 10;
    }

    @RequestMapping("/t3")
    public boolean t3() {
        return true;
    }

    @RequestMapping("/t4")
    public BookInfo t4() {
        return new BookInfo();
    }
}
