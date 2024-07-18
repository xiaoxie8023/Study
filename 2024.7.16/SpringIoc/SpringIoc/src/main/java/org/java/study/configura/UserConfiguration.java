package org.java.study.configura;

import org.springframework.context.annotation.Configuration;

/**
 * program: SpringIoc
 * <p>
 * description: 配置层
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-18 08:34
 **/
@Configuration
public class UserConfiguration {
    public void sayHi() {
        System.out.println("Hi, UserConfiguration");
    }
}
