package com.yun.demo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import com.yun.demo.model.CaptchaProperties;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    @Autowired
    private CaptchaProperties captchaProperties;

    @RequestMapping("/generate")
    public void generate(HttpSession session, HttpServletResponse response) throws IOException {
        ICaptcha captcha = CaptchaUtil.createLineCaptcha(captchaProperties.getWidth(), captchaProperties.getHeight());
        captcha.write(response.getOutputStream());
        response.setHeader("Prama", "No-cache");
        response.setContentType("image/jpeg");
        //Servlet的OutputStream记得自行关闭哦！
        session.setAttribute(captchaProperties.getSession().getCode(), captcha.getCode());
        session.setAttribute(captchaProperties.getSession().getDate(), System.currentTimeMillis());
        response.getOutputStream().close();
    }

    @RequestMapping("/check")
    public boolean check(String code, HttpSession session) {
        if (!StringUtils.hasLength(code)) {
            return false;
        }
        String codeS = (String) session.getAttribute(captchaProperties.getSession().getCode());
        Long time = (Long) session.getAttribute(captchaProperties.getSession().getDate());
        if (time != null && code.equalsIgnoreCase(codeS) && (System.currentTimeMillis() - time) < captchaProperties.getTime()) {
            return true;
        }

        return false;
    }
}
