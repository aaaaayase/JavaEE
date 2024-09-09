package com.yun.principle;

import com.yun.config.YunConfig1;
import com.yun.principle.mapper.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootTest
class SpringPrincipleApplicationTests {
    @Autowired
    ApplicationContext context;

    @Test
    void contextLoads() {
        YunConfig1 yunConfig = (YunConfig1) context.getBean("yunConfig1");
        System.out.println(yunConfig);
    }

}
