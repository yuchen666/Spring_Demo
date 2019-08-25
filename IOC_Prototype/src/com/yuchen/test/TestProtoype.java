package com.yuchen.test;

import com.yuchen.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProtoype {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user1 = (User) applicationContext.getBean("user");
        User user2 = (User) applicationContext.getBean("user");
        /***
         * 输出结果为
         * 创建了User对象
         * 创建了User对象
         * false
         * 执行了两次User的无参构造函数，且执行结果为false，说明创建的是两个不同的User对象
         */
        System.out.println(user1 == user2);
    }
}
