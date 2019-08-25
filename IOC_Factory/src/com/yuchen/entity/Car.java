package com.yuchen.entity;

import lombok.Data;

@Data
public class Car {
    private int num;
    private String brand;

    public Car() {
    }

    public Car(int num, String brand) {
        super();
        this.num = num;
        this.brand = brand;
    }
}