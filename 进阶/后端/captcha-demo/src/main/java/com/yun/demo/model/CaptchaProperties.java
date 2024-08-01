package com.yun.demo.model;

import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties("captcha")
@Component
public class CaptchaProperties {
    private int width;
    private int height;
    private Session session;
    private int time;

    @Data
    public static class Session {
        private String code;
        private String date;
    }
}
