package org.example.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * program: SpringBoot
 * <p>
 * description: 测试
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-09 13:32
 **/
@RequestMapping("/Text")
@RestController
public class TextController {
    @RequestMapping("/Text1")
    public String Text1() {
        return "Hello World";
    }
    @RequestMapping("/Text2")
    public String Text2(String name) {
        System.out.println("Hello " + name);
        return "Text2" + name;
    }
    @RequestMapping("/Text3")
    public String Text3(Integer age) {
        System.out.println("Hello " + age);
        return "Text3" + age;
    }
    @RequestMapping("/Text4")
    public String Text4(int age) {
        System.out.println("Hello " + age);
        return "Text3" + age;
    }
    @RequestMapping("/Text5")
    public String Text5(UserInfo userInfo) {
        return "Text5: " + userInfo;
    }
    @RequestMapping("/Text6")
    public  String Text6(@RequestParam(value = "name",required = false) String UserName, Integer age) {
        return "Text6: " + UserName + ", age: " + age;
    }
    @RequestMapping("/Text7")
    public String Text7(UserInfo userInfo) {
        return "Text5: " + userInfo;
    }

}
