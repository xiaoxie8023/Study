package org.example.springmvctext;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * program: SpringMvcText
 * <p>
 * description: SpringMvc复习
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-12 20:28
 **/

@RequestMapping("/Text")
@RestController
public class TextController {
    //关于传输数组接口的测试
    @RequestMapping("/Text1")
    public String Text1(String[] arrParams) {
        return Arrays.toString(arrParams);
    }
    @RequestMapping("/Text2")
    public List<String> Text2(@RequestParam("arrParams") List<String> arrParams) {
        return Collections.singletonList(arrParams.toString());
    }

}

