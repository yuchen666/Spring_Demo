package com.yuchen.test;

import com.yuchen.entity.User;
import com.yuchen.service.ApplicationContext;
import com.yuchen.service.impl.ClassPathXmlApplicationContext;

public class UserTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = (User)applicationContext.getBean("user");
        System.out.println("user = " + user);
    }
}
