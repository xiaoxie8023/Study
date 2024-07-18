package org.java.study.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * program: SpringIoc
 * <p>
 * description: 控制层
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-18 08:00
 **/
@Controller
public class UserController {

    public void sayHi() {
        System.out.println("Hi, UserController");
    }
}
