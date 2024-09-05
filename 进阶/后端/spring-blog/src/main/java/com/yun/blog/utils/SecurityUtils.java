package com.yun.blog.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Slf4j
public class SecurityUtils {

    public static String encrypt(String password) throws UnsupportedEncodingException {
        String salt = UUID.randomUUID().toString().replace("-", "");
        String secretString = DigestUtils.md5DigestAsHex((salt + password).getBytes("UTF-8"));
        return salt + secretString;
    }

    public static boolean verify(String password, String finalPassword) {
        if (finalPassword == null || finalPassword.length() != 64) {
            log.error("密码长度不足");
            return false;
        }
        String salt = finalPassword.substring(0, 32);
        String secretString = null;
        try {
            secretString = DigestUtils.md5DigestAsHex((salt + password).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            log.error("getBytes 异常，e:", e);
            throw new RuntimeException(e);
        }

        return (salt + secretString).equals(finalPassword);
    }
}
