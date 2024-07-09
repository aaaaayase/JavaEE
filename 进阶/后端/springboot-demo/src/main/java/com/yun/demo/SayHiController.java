package com.yun.demo;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHiController {
    @RequestMapping("/SayHi")
    public String SayHi() {
        return "Hello World";
    }
}
