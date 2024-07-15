package org.example.springmvctext;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

/**
 * program: SpringMvcText
 * <p>
 * description: 请求控制
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-13 21:00
 **/
@RestController
@RequestMapping("/request")
public class ResultController {
    //从URL获取到参数
    @RequestMapping("/getId/{id}")
    public String getId ( @PathVariable("id") Integer id) {
        return "获取的参数为 : " + id;
    }
    //获取URL中多个参数
    @RequestMapping("/getData/{name}/{age}")
    public String Text(@PathVariable("name") String name, @PathVariable Integer age) {
        return "name : " + name + ", age : " + age;
    }
    //使用传统的方法获取到Cookie
    @RequestMapping("/getCookie1")
    public String getCookie1(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            System.out.println("获取Cookie失败");
           return null;
        }
        for (Cookie cookie : cookies) {
            System.out.println("name: " + cookie.getName() + ": value: " + cookie.getValue());
        }
        return "获取Cookie成功";
    }
    //使用注解
    @RequestMapping("/getCookie2")
    public String getCookie2(@CookieValue("name") String name) {
        System.out.println("获取到的name: " + name);
        return "获取成功";
    }
    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request) {
        //写成true是为了如果没有就生成一个session
        HttpSession session = request.getSession(true);
         session.setAttribute("name", "张三");
         session.setAttribute("age", 20);
         return "设置session成功";
    }
    //获取Session方法1
    @RequestMapping("/getSession1")
    public String getSession1(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "获取失败";
        }
        System.out.println(session.getAttribute("name"));
        System.out.println(session.getAttribute("age"));
        return "获取Session成功";
    }
    //获取Session方法2
    @RequestMapping("/getSession2")
    public String getSession2(HttpSession session) {
        System.out.println(session.getAttribute("name"));
        System.out.println(session.getAttribute("age"));
        return  "获取Session成功";
    }
    //获取Session方法3使用注解
    @RequestMapping("/getSession3")
    public String getSession(@SessionAttribute("name") String name) {
        System.out.println("name: " + name);
        return "获取Session成功";
    }
    @RequestMapping("/getHeader1")
    public String getHeader1(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        return "User-Agent" + header;
    }
    @RequestMapping("/getHeader2")
    public  String getHeader2(@RequestHeader("User-Agent") String agent) {
        return "User-Agent"+agent;
    }
}
