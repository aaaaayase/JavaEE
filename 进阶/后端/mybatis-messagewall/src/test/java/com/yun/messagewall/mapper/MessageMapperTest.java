package com.yun.messagewall.mapper;

import com.yun.messagewall.model.MessageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageMapperTest {

    @Autowired
    MessageMapper mapper;

    @Test
    void select() {
        mapper.select().forEach(System.out::println);
    }

    @Test
    void insert() {
        MessageInfo message = new MessageInfo();
        message.setFrom("12");
        message.setTo("13");
        message.setMessage("好好好");
        mapper.insert(message);
    }
}