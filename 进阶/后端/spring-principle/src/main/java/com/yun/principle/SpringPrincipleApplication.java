package com.yun.principle;

import com.yun.config.MyRegistrar;
import com.yun.config.YunConfig1;
import com.yun.principle.mapper.UserInfoMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

//@EnableYunConfig
//@ComponentScan("com.yun.principle")
@Import(MyRegistrar.class)
@SpringBootApplication
public class SpringPrincipleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringPrincipleApplication.class, args);
        YunConfig1 bean = context.getBean(YunConfig1.class);
        UserInfoMapper bean1 = context.getBean(UserInfoMapper.class);
    }

}
