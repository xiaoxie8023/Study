package org.example.springmvctext;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * program: SpringMvcText
 * <p>
 * description: 作业
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-13 19:17
 **/
@RestController
public class WorkController {
    @RequestMapping("/sayHi")
    public String sayHello() {
        return "Hello World";
    }

}
