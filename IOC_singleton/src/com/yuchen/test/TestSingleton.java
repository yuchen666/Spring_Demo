package com.yuchen.test;

import com.yuchen.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSingleton {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user1 = (User)applicationContext.getBean("user");
        User user2 = (User)applicationContext.getBean("user");
        System.out.println(user1 == user2);
    }
}
