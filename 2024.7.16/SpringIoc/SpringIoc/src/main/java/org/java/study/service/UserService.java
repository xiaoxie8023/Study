package org.java.study.service;

import org.springframework.stereotype.Service;

/**
 * program: SpringIoc
 * <p>
 * description: 业务逻辑层
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-18 08:17
 **/
@Service
public class UserService {
    public void sayHello() {
        System.out.println("Hello UserService");
    }
}
