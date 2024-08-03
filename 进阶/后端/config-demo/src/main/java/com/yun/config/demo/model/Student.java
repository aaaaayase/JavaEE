package com.yun.config.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties("student")
@Data
public class Student {
    private int id;
    private String name;
    private List<Integer> list;
    private Map<String, Integer> map;
}
