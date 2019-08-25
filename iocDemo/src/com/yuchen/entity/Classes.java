package com.yuchen.entity;

import lombok.Data;

import java.util.List;

@Data
public class Classes {
    private int id;
    private String name;
    private List<Student> students;

    public Classes() {
    }

    public Classes(int id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }
}
