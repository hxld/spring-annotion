package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hxld
 * @create 2022-08-06 11:19
 */

//默认加在Ioc 容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作
@Component
public class Boss {

    private  Car car;

    public Car getCar() {
        return car;
    }

//    @Autowired
    //标注在构造器中的，也是从容器中获取Car这个组件
    public Boss(@Autowired Car car) {
        this.car = car;
        System.out.println("BOSS ... 有参构造器");
    }

    @Autowired
    //标注在方法上，spring容器创建当前对象，就会调用方法，完成赋值。
    //方法使用的参数，自定义类型的值从Ioc容器中获取。
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
