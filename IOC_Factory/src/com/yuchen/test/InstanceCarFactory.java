package com.yuchen.test;

import com.yuchen.entity.Car;

import java.util.HashMap;
import java.util.Map;

/***
 * 实例工厂方法
 */
public class InstanceCarFactory {
    private Map<Integer, Car> cars;
    public InstanceCarFactory(){
        cars = new HashMap<Integer, Car>();
        cars.put(1,new Car(1,"奥迪"));
        cars.put(2,new Car(2,"奥拓"));
    }
    public Car getCar(int num){
        return cars.get(num);
    }
}
