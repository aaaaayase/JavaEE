package com.yun.springmvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtilTests {
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        UserInfo user = new UserInfo("dasd", 11, "daas");
        String str = objectMapper.writeValueAsString(user);
        System.out.println(str);
        String str2 = "{\"userName\":\"dasd\",\"age\":11,\"password\":\"daas\"}";

        UserInfo user1 = objectMapper.readValue(str2, UserInfo.class);
        System.out.println(user1);
    }
}
