package com.yuchen.entity;

import lombok.Data;

@Data
public class Person {
    private int id;
    private String name;
    private Car car;
}