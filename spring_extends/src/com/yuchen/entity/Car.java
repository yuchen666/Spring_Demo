package com.yuchen.entity;

import lombok.Data;

@Data
public class Car {
    private int id;
    private String brand;

    public Car() {
        System.out.println("创建了Car对象");
    }
}
