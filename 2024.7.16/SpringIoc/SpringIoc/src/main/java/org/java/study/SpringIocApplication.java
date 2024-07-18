package org.java.study;

import lombok.val;
import org.java.study.component.UserComponent;
import org.java.study.configura.UserConfiguration;
import org.java.study.controller.US;
import org.java.study.controller.UserController;
import org.java.study.dao.UserDao;
import org.java.study.model.UserInfo;
import org.java.study.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringIocApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);
         //使用Controller
        //使用类类型来获取bean
//        UserController userController = context.getBean(UserController.class);
//        userController.sayHi();
//        System.out.println(userController);
//        //使用bean的名称来获取:规则是: 1.大驼峰变成小驼峰 2.两个首字母大写就不变
//        UserController userController1 = (UserController) context.getBean("userController");
//        userController1.sayHi();
//        System.out.println(userController1);
//        US us = (US) context.getBean("US");
//        us.sayHi();
//        System.out.println(us);
//        //使用名称加上类型
//        UserController userController2 = context.getBean("userController", UserController.class);
//        userController2.sayHi();
//        System.out.println(userController2);
//        US us1 = context.getBean("US", US.class);
//        us1.sayHi();
//        System.out.println(us1);
        //使用@Service
        //使用类类型来获取bean
//        UserService userService = context.getBean(UserService.class);
//        userService.sayHello();
//        System.out.println(userService);
//        //使用bean的名称来获取:规则是: 1.大驼峰变成小驼峰 2.两个首字母大写就不变
//        UserService userService1 = (UserService)context.getBean("userService");
//        userService1.sayHello();
//        System.out.println(userService1);
//        //使用名称加上类型
//        UserService userService2 = context.getBean("userService", UserService.class);
//        userService2.sayHello();
//        System.out.println(userService2);
//        //数据层
//        //使用类类型来获取bean
//        UserDao userDao = context.getBean(UserDao.class);
//        userDao.sayHello();
//        System.out.println(userDao);
//        //使用bean的名称来获取:规则是: 1.大驼峰变成小驼峰 2.两个首字母大写就不变
//        UserDao userDao1 = (UserDao) context.getBean("userDao");
//        userDao1.sayHello();
//        System.out.println(userDao1);
//        //使用名称加上类型
//        UserDao userDao2 = context.getBean("userDao", UserDao.class);
//        userDao2.sayHello();
//        System.out.println(userDao2);
        //配置层
        //使用类类型来获取bean
//        UserConfiguration userConfiguration = context.getBean(UserConfiguration.class);
//        userConfiguration.sayHi();
//        System.out.println(userConfiguration);
//        //使用bean的名称来获取:规则是: 1.大驼峰变成小驼峰 2.两个首字母大写就不变
//        UserConfiguration userConfiguration1 = (UserConfiguration) context.getBean("userConfiguration" + "");
//        userConfiguration1.sayHi();
//        System.out.println(userConfiguration1);
//        //使用名称加上类型
//        UserConfiguration userConfiguration2 = context.getBean("userConfiguration", UserConfiguration.class);
//        userConfiguration2.sayHi();
//        System.out.println(userConfiguration2);
//        //组件层
//        //使用类类型来获取bean
//        UserComponent userComponent = context.getBean(UserComponent.class);
//        userComponent.sayHi();
//        System.out.println(userComponent);
//        //使用bean的名称来获取:规则是: 1.大驼峰变成小驼峰 2.两个首字母大写就不变
//        UserComponent userComponent1 = (UserComponent) context.getBean("userComponent");
//        userComponent1.sayHi();
//        System.out.println(userComponent1);
//        //使用名称加上类型
//        UserComponent userComponent2 = context.getBean("userComponent", UserComponent.class);
//        userComponent2.sayHi();
//        System.out.println(userComponent2);
        //获取bean
//        UserInfo userInfo = context.getBean(UserInfo.class);
//        System.out.println(userInfo);
        //使用bean的名称来获取:规则是: 1.大驼峰变成小驼峰 2.两个首字母大写就不变
        UserInfo getUserInfo1 =(UserInfo) context.getBean("u1");
        UserInfo getUserInfo2 = (UserInfo)context.getBean("getUserInfo2");
        System.out.println(getUserInfo1);
        System.out.println(getUserInfo2);
        //使用名称加上类型
        UserInfo getUserInfo11 = context.getBean("u2", UserInfo.class);
        System.out.println(getUserInfo11);
        UserInfo getUserInfo12 = context.getBean("getUserInfo2", UserInfo.class);
        System.out.println(getUserInfo12);
    }


}
