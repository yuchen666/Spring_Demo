package com.yuchen.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Car car;

    public User() {
        System.out.println("创建了User对象");
    }

}
