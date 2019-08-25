package com.yuchen.test;

import com.yuchen.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = (User)applicationContext.getBean("user");
        System.out.println("user = " + user);
    }
}
