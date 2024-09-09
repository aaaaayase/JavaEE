package com.yun.principle.config;

import com.yun.principle.model.Dog;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class DogConfig {

    @Bean
    public Dog dog() {
        return new Dog();
    }

    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Dog dogSingle() {
        return new Dog();
    }

    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Dog dogPro() {
        return new Dog();
    }

    @Bean
    @RequestScope
    public Dog dogRequest() {
        return new Dog();
    }

    @Bean
    @SessionScope
    public Dog dogSession() {
        return new Dog();
    }

    @Bean
    @ApplicationScope
    public Dog dogApplication() {
        return new Dog();
    }
}
