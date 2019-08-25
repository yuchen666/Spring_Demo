package com.yuchen.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuchen.entity.Car;

public class TestStaticFactory {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Car car = (Car) applicationContext.getBean("car1");
        System.out.println(car);
    }
}
