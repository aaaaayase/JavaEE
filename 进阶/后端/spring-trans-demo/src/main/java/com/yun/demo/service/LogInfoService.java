package com.yun.demo.service;

import com.yun.demo.mapper.LogInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInfoService {
    @Autowired
    private LogInfoMapper logInfoMapper;

    public Integer insert(String name, String op) {
        Integer result = logInfoMapper.insert(name, op);
        return result;
    }
}
