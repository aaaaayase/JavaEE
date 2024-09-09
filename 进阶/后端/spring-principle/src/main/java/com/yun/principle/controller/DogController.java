package com.yun.principle.controller;

import com.yun.principle.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

@RequestMapping("/dog")
@RestController
public class DogController {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private Dog dog;

    @Autowired
    private Dog dogSingle;

    @Autowired
    private Dog dogPro;

    @Autowired
    private Dog dogRequest;

    @Autowired
    private Dog dogSession;

    @Autowired
    private Dog dogApplication;

    @RequestMapping("/default")
    public String getDog() {
        Dog dog1 = context.getBean("dog", Dog.class);

        return "context:" + dog1 + " autowired注入:" + dog;

    }

    @RequestMapping("/singleton")
    public String getDogSingle() {
        Dog dog1 = context.getBean("dogSingle", Dog.class);

        return "context:" + dog1 + " autowired注入:" + dogSingle;

    }

    @RequestMapping("/pro")
    public String getDogPro() {
        Dog dog1 = context.getBean("dogPro", Dog.class);

        return "context:" + dog1 + " autowired注入:" + dogPro;

    }

    @RequestMapping("/request")
    public String getDogRequest() {
        Dog dog1 = context.getBean("dogRequest", Dog.class);

        return "context:" + dog1 + " autowired注入:" + dogRequest;

    }

    @RequestMapping("/session")
    public String getDogSession() {
        Dog dog1 = context.getBean("dogSession", Dog.class);

        return "context:" + dog1 + " autowired注入:" + dogSession;

    }

    @RequestMapping("/application")
    public String getDogApplication() {
        Dog dog1 = context.getBean("dogApplication", Dog.class);

        return "context:" + dog1 + " autowired注入:" + dogApplication;

    }

}
