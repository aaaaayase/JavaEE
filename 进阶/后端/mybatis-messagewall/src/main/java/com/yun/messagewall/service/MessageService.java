package com.yun.messagewall.service;

import com.yun.messagewall.mapper.MessageMapper;
import com.yun.messagewall.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public List<MessageInfo> select() {
        return messageMapper.select();
    }

    public void insert(MessageInfo message) {
        messageMapper.insert(message);
    }
}
