package com.yun.book.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yun.book.constant.Constants;
import com.yun.book.model.Result;
import com.yun.book.model.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Intercepts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    ObjectMapper mapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("用户登录校验");
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.USER_SESSION_KEY);
        if (userInfo == null) {
            response.setStatus(401);
            response.setContentType("application/json;charset=utf-8");
            Result result = Result.fail("用户未登录");
            response.getOutputStream().write(mapper.writeValueAsString(result).getBytes());
            // 返回false就会拦截
            return false;
        }
        log.info("用户校验通过");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("目标方法执行后");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("视图渲染完成后");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
