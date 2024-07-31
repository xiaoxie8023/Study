package org.example.springworkbook.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * program: SpringWorkBook
 * <p>
 * description: 图书管理系统
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-16 07:32
 **/
@RestController
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/login")
    public String login(String userName, String password, HttpSession session) {
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return "用户名或者密码不能为空";
        }
        if(!"张三".equals(userName) || !"123456".equals(password)) {
            return "密码或者用户名错误";
        }
        session.setAttribute("userName", userName);
        return "success";
    }
}
