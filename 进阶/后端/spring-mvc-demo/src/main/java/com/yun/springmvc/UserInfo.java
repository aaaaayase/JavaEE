package com.yun.springmvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfo {

    private String userName;
    private int age;
    private String password;

    public UserInfo(String userName, int age, String password) {
        this.userName = userName;
        this.age = age;
        this.password = password;
    }

}
