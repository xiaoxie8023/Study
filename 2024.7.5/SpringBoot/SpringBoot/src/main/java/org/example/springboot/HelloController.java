package org.example.springboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * program: SpringBoot
 * <p>
 * description:
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-08 10:26
 **/
@RestController
public class HelloController {
    @RequestMapping ("/hello")
   public String sayHello() {
       return "Hello Spring Boot! I am Spring Boot!";
   }
    @RequestMapping("/hello111")
    public Integer hello2(){
        int[] nums = new int[20];
        nums[0] = 1;
        return  20;
    }
}
