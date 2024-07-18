package org.java.study.component;

import org.springframework.stereotype.Component;

/**
 * program: SpringIoc
 * <p>
 * description: 组件层
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-18 08:39
 **/
@Component
public class UserComponent {
    public void sayHi() {
        System.out.println("Hi, UserComponent");
    }
}
