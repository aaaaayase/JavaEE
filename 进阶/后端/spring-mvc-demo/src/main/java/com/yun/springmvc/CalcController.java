package com.yun.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalcController {

    @RequestMapping("/sum")
    public String sum(Integer num1, Integer num2) {
        return "计算结果：" + (num1 + num2);
    }
}
