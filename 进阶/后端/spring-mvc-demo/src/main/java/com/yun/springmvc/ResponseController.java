package com.yun.springmvc;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/response")
@Controller
public class ResponseController {

    // 返回视图
    @RequestMapping("/index")
    public String index() {
        // 如果这里加上斜杠 就要在static文件夹中构建出 response/index.html这样的路径
        // 不加斜杠正常写函数路由即可
        return "/index.html";
    }

    // 返回数据
    @ResponseBody
    @RequestMapping("/returnData")
    public String returnData() {
        return "/index.html";
    }

    @ResponseBody
    @RequestMapping("/returnHtml")
    public String returnHtml() {
        return "<h1>返回Html</h1>";
    }

    @ResponseBody
    @RequestMapping("/returnJson")
    public UserInfo returnJson() {
        UserInfo user = new UserInfo("yun", 12, "212312");
        return user;
    }

    @ResponseBody
    @RequestMapping("/setStatus")
    public String setStatus(HttpServletResponse response) {
        response.setStatus(401);
        return "状态设置完成";
    }

    @ResponseBody
    @RequestMapping(value = "/returnJson2",produces = "application/json;charset=UTF-8")
    public String returnJson2() {

        return "{\"status\":111}";
    }

    @ResponseBody
    @RequestMapping("/setHeader")
    public String setHeader(HttpServletResponse response) {
        response.setHeader("name","value");
        return "设置完成";
    }
}
