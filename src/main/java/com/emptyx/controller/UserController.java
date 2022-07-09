package com.emptyx.controller;

import com.emptyx.entity.User;
import com.emptyx.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author emptyx
 * @Date 2022/6/20 12:28
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /*注册页面*/
    @GetMapping("/register")
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Register");
        return modelAndView;
    }

    /*注册操作*/
    @PostMapping("/register")
    public void toLogin(User user, HttpServletResponse response) throws IOException {
        int result = userService.addUser(user);
        if (result > 0){
            response.sendRedirect("/login");
        }else {
            response.sendRedirect("/register");
        }
    }

    /*登录页面*/
    @GetMapping("/login")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","请先登录");
        modelAndView.setViewName("Login");
        return modelAndView;
    }

    /*登录操作*/
    @PostMapping("/login")
    public ModelAndView toRegister(User user, HttpSession session, HttpServletResponse response) throws IOException {
        User user1 = userService.queryUserPassword(user);
        if(user1.getPassword().equals(user.getPassword())){
            session.setAttribute("userId",user1.getId());
            session.setAttribute("isLogin","已登录");
            session.setAttribute("userName",user1.getUserName());
            response.sendRedirect("/");
            return null;
        }else{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("message","密码输入错误");
            modelAndView.setViewName("Login");
            return modelAndView;
        }
    }

    /*退出登录*/
    @GetMapping("/logout")
    public void loginOut(HttpSession session,HttpServletResponse response) throws IOException {
        session.removeAttribute("userId");
        session.removeAttribute("isLogin");
        session.removeAttribute("userName");
        response.sendRedirect("/");
    }

    /*index页面*/
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
