package com.yuchen.entity;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private int age;
    //private Classes classes;

    public Student(){

    }

    /***
     * 创建有参构造函数时，必须要创建一个无参构造函数
     * @param id
     * @param name
     * @param age
     */

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        //this.classes = classes;
    }
}

