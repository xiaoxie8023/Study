package org.java.study.controller;

import org.java.study.model.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

/**
 * program: SpringIoc
 * <p>
 * description: 两个首字母大写
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-18 08:10
 **/
@Controller
public class US {
    @Bean({"u1", "u2"})
    public UserInfo getUserInfo1() {
        return new UserInfo(1,"张三");
    }
    @Bean
    public UserInfo getUserInfo2() {
        return new UserInfo(1,"李四");
    }
}
