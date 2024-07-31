package org.example.springmvctext;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * program: SpringMvcText
 * <p>
 * description: 计算器的实现
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-14 08:30
 **/
@RestController
@RequestMapping("/calc")
public class CalcController {
    @RequestMapping("/sum")
    public String sum(Integer num1, Integer num2) {
        Integer sum = num1 + num2;
        return "计算结果" + sum;
    }
}
