package com.emptyx.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author emptyx
 * @Date 2022/6/27 18:11
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        if ("已登录".equals(session.getAttribute("isLogin"))){
            return true;
        }else {
            response.sendRedirect("/user/login");
            return false;
        }
    }
}
