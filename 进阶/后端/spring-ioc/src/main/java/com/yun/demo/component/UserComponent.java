package com.yun.demo.component;

import com.yun.demo.model.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    public void sayHi() {
        System.out.println("Hi,UserComponent...");
    }

    // bean注解需要搭配五大注解使用
    // bean注解的作用就是可以创建类的多个不同对象交给spring管理
    // 默认对象的名称就是方法名
    // 可以通过在注解后加字符串来指定对象名称 并且可以给对象指定多个名称 五大注解和bean注解都是一样
    // bean注解还有一个作用就是给第三方的类去创建对象 因为在第三方类中我们是加不了五大注解的
    @Bean
    public UserInfo userInfo1() {
        return new UserInfo(12,"zhangsan");
    }

    @Bean({"u1","u2"})
    public UserInfo userInfo2() {
        return new UserInfo(12,"zhangsan");
    }

}
