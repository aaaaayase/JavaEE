package com.yun.springmvc;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    List<MessageInfo> list = new ArrayList<>();

    @RequestMapping("/publish")
    public Boolean publish(@RequestBody MessageInfo messageInfo) {
        list.add(messageInfo);
        return true;
    }

    @RequestMapping("/getList")
    public List<MessageInfo> getList() {
        return list;
    }
}
