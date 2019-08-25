package com.yuchen.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private int age;

    public User() {
        System.out.println(" 创建了一个User对象" );
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
