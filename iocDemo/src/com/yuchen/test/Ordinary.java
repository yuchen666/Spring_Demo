package com.yuchen.test;

import com.yuchen.entity.Student;

/***
 * 常规操作需要new一个Student实例
 */
public class Ordinary {
    public static void main(String[] args) {

        Student student = new Student();

        student.setId(1);
        student.setName("于晨");
        student.setAge(22);

        System.out.println(student.toString());
    }
}
