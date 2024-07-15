package org.example.springmvctext;

import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * program: SpringMvcText
 * <p>
 * description: 用户登录界面
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-14 08:41
 **/
@RestController
@RequestMapping("/user")
public class UserLoginController {
    @RequestMapping("/login")
    public boolean userLogin(String userName, String password, HttpSession session) {
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return false;
        }
        if("张三".equals(userName) && "123456".equals(password)) {
            session.setAttribute("userName", userName);
            return true;
        }
        return false;
    }
    @RequestMapping("/getUserInfo")
    public String getUserInfo(HttpSession session){
        String userName = (String) session.getAttribute("userName");
        System.out.println("登录用户:"+ userName);
        return userName==null?"":userName;
    }
}
