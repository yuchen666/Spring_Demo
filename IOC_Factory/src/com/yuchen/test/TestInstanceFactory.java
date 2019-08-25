package com.yuchen.test;

import com.yuchen.entity.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInstanceFactory {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Car car = (Car) applicationContext.getBean("car2");
        System.out.println("car = " + car);
    }
}
