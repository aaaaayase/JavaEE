package com.yun.springmvc;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session) {
        if (!StringUtils.hasLength(userName) && !StringUtils.hasLength(password)) {
            return false;
        }

        if ("zhangsan".equals(userName) && "123456".equals(password)) {
            session.setAttribute("userName", userName);
            session.setAttribute("password", password);
            return true;
        }

        return false;
    }

    @RequestMapping("/getUserInfo")
    public String getUserInfo(HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        return userName == null ? "" : userName;
    }

}
