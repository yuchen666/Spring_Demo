package com.yuchen.test;

import com.yuchen.entity.Car;
import com.yuchen.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring_Extends1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        /*User user1 = (User)applicationContext.getBean("user1");
        System.out.println("user1 = " + user1);*/
        User user = (User)applicationContext.getBean("user");
        Car car = (Car)applicationContext.getBean("car");
    }
}
