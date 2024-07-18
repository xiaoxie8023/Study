package org.java.study.dao;

import org.springframework.stereotype.Repository;

/**
 * program: SpringIoc
 * <p>
 * description: 数据层
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-18 08:28
 **/
@Repository
public class UserDao {
    public void sayHello() {
        System.out.println("Hello UserDao");
    }
}
