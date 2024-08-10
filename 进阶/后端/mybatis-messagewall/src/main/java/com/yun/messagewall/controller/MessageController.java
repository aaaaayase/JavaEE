package com.yun.messagewall.controller;

import com.yun.messagewall.model.MessageInfo;
import com.yun.messagewall.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messagewall")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/getList")
    public List<MessageInfo> getList() {
        List<MessageInfo> messageList = messageService.select();
        return messageList;
    }

    @RequestMapping("/publish")
    public boolean publish(@RequestBody MessageInfo message) {

        if(StringUtils.hasLength(message.getFrom())&&StringUtils.hasLength(message.getTo())&&StringUtils.hasLength(message.getMessage())) {

            messageService.insert(message);
            return true;
        }
        return false;
    }
}
