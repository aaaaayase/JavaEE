package com.yun.springmvc;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.Session;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/param")
@RestController
public class RequestController {

    // 构造的请求传输的参数名称需要和函数这里的userName形参一致
    // 当传过来多个参数 函数不会管 最终只会接收这里的对应的参数
    @RequestMapping("/param1")
    public String param1(String userName) {
        System.out.println("1获取到参数" + userName);
        return "1获取到参数" + userName;
    }


    @RequestMapping("/param2")
    public String param2(String userName, Integer age) {
        System.out.println("2获取到参数" + userName + " " + age);
        return "2获取到参数" + userName + " " + age;
    }

    // 当函数这里的类型是int时 一旦传输过来的参数值不是数字或者为空就会报错
    // integer类型参数传来为空还会置为null int直接报错 因此最好使用integer
    @RequestMapping("/param3")
    public String param3(String userName, int age) {
        System.out.println("3获取到参数" + userName + " " + age);
        return "3获取到参数" + userName + " " + age;
    }

    // 后端参数重命名
    // 如果说我们就是想要去修改形参并且想要去使修改后的形参去接收传递过来的参数
    // 我们可以使用requestparam注解 参数注解
    // 将userName和name绑定起来了
    // 添加注解之后 这里的参数成了必填项 无论你传什么可以传空白但是必须传过来否则返回错误
    // 如果说不想被强制传 你们可以设置requestParam注解的参数required
    @RequestMapping("/param4")
    public String param4(@RequestParam(value = "userName", required = false) String name, Integer age) {
        System.out.println("4获取到参数" + name + " " + age);
        return "4获取到参数" + name + " " + age;
    }

    // 传对象
    // 当对象中属性是int类型时没有关系 对象会初始化int类型为0 不传参不会报错
    // get方法在body中传对象会有问题 试试
    @RequestMapping("/param5")
    public String param5(UserInfo userInfo) {
        System.out.println(userInfo.toString());
        return userInfo.toString();
    }

    // 这个代表被废弃 后面调用该方法会有删除线 当我们需要给这样的接口加参数时
    // 就可以使用该注解 因为我们直接重新写一个多参数接口 废弃掉原接口 这是符合开闭原则的
    @Deprecated
    @RequestMapping("/param6")
    public String param6(String userName, int age) {
        System.out.println("6获取到参数" + userName + " " + age);
        return "6获取到参数" + userName + " " + age;
    }

    @RequestMapping("/param7")
    public String param7(Integer[] arr) {
        System.out.println("接收到参数：" + Arrays.toString(arr));
        return "接收到参数" + Arrays.toString(arr);

    }

    // 传递集合时需要使用参数注解进行绑定 不然会将传过来的数据构成数组然后造成错误
    @RequestMapping("/param8")
    public String param8(@RequestParam("list") List<Integer> list) {
        System.out.println("接收到参数" + list);
        return "接收到参数" + list;
    }

    // 接收url中的参数
    @RequestMapping("/param9/{name}/{age}")
    public String param10(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        System.out.println("接收到参数" + name + " " + age);
        return "接收到参数" + name + " " + age;
    }

    // name是必传参数 当两个param10函数采用不同的路径构成了类似于函数重载的效果
    @RequestMapping("/param9/{name1}")
    public String param10(@PathVariable("name1") String name) {
        System.out.println("接收到参数" + name);
        return "接收到参数" + name;
    }

    // 传输json格式数据
    @RequestMapping("/param10")
    public String param10(@RequestBody UserInfo user) {
        System.out.println("接收到参数" + user);
        return "接收到参数" + user;
    }

    // 传输文件
    @RequestMapping("/param11")
    public String param11(@RequestPart("file1") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        file.transferTo(new File("F:/" + file.getOriginalFilename()));
        return "接收文件" + file.getOriginalFilename();
    }

    @RequestMapping("/getCookie")
    public String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("yun".equals(cookie.getName())) {
                    System.out.println("找到了" + cookie.getName() + ":" + cookie.getValue());
                } else {
                    System.out.println(cookie.getName() + ":" + cookie.getValue());
                }
            }
        }
        return "获取Cookie成功";
    }

    @RequestMapping("/getCookie2")
    public String getCookie2(@CookieValue("yun") String value) {

        return "获取Cookie成功" + value;
    }

    // 设置session
    // true代表即使没有session也会创建
    // false代表没有就返回null
    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request) {
        HttpSession session = request.getSession(true);

        session.setAttribute("name", "yun");
        session.setAttribute("age", "24");

        return "session设置完成";
    }

    // 获取session
    // 这里获取session要注意一点就是session是存在内存当中的
    // 因此如果服务器重启就会销毁 在这里就是代码终止session就没了
    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            System.out.println(session.getAttribute("name"));
            System.out.println(session.getAttribute("age"));
        }
        return "获取session成功";
    }

    @RequestMapping("/getSession2")
    public String getSession2(HttpSession session) {

        System.out.println(session.getAttribute("name"));
        System.out.println(session.getAttribute("age"));

        return "获取session成功";
    }

    @RequestMapping("/getSession3")
    public String getSession3(@SessionAttribute("name") String name) {
        return "获取session成功" + name;
    }

    @RequestMapping("/getHeader")
    public String getHeader(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        System.out.println(userAgent);
        return "获取Header成功";
    }
 
    @RequestMapping("/getHeader2")
    public String getHeader2(@RequestHeader("User-Agent") String userAgent) {
        System.out.println(userAgent);
        return "获取Header成功";
    }
}
