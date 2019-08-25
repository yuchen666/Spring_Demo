package com.yuchen.test;

import com.yuchen.controller.UserController;
import com.yuchen.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserController userController = (UserController)applicationContext.getBean("userController");
        User user = userController.getUserById(1);
        System.out.println("user = " + user);
    }
}
