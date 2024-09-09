package com.yun.principle.component;

import com.yun.principle.model.Dog;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BeanLifeComponent implements BeanNameAware {

    private Dog dog;

    public BeanLifeComponent() {
        log.info("执行构造函数");
    }
    
    @Autowired
    public BeanLifeComponent(Dog dog) {
        this.dog = dog;
        log.info("构造函数注入");
    }

//    @Autowired
//    public void setDog(Dog dog) {
//        this.dog=dog;
//        log.info("属性注入");
//    }

    @PostConstruct
    public void init() {
        log.info("初始化执行init方法");
    }

    public void use() {
        log.info("使用bean");
    }

    @PreDestroy
    public void destroy() {
        log.info("执行销毁方法");
    }

    @Override
    public void setBeanName(String name) {
        log.info("执行通知" + name);
    }
}
