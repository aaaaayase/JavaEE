package com.yun.blog.utils;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.ServiceLoader;
import java.util.UUID;

public class SecurityUtilsTest {

    @Test
    public void gen() throws UnsupportedEncodingException {
        String password = "123456";
        String salt = UUID.randomUUID().toString().replace("-", "");
        String secretString = DigestUtils.md5DigestAsHex((salt + password).getBytes("UTF-8"));
        String sqlPassword = salt + secretString;
        System.out.println(sqlPassword);
    }


    @Test
    public void verify() {
        String password = "123456";
        String sqlPassword = "2fde521a5c214b258d99def5c64ac9cc6467a63ffcf827168f21b89c391db0f4";
        String salt = sqlPassword.substring(0, 32);

        String s = DigestUtils.md5DigestAsHex((salt + password).getBytes());

        System.out.println((salt + s).equals(sqlPassword));

    }

}
