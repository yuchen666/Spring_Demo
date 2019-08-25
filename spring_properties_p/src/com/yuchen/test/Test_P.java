package com.yuchen.test;

import com.yuchen.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_P {
    public static void main(String[] args) {
        /***
         * 获取spring.xml配置
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        /***
         * 创建User对象
         */
        User user = (User) applicationContext.getBean("user");
        System.out.println("user = " + user);
    }
}
