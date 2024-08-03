package com.yun.config.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prop")
public class PropertiesController {

    @Value("${font.size}")
    private String font;

    @RequestMapping("/getFont")
    public String getFont() {
        return "font.size:" + font;
    }
}
