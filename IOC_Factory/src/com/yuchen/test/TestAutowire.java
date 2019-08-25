package com.yuchen.test;

import com.yuchen.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutowire {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
