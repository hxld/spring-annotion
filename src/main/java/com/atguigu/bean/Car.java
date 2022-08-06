package com.atguigu.bean;

import org.springframework.stereotype.Component;

/**
 * @author hxld
 * @create 2022-08-05 15:08
 */
@Component
public class Car {

    public Car(){
        System.out.println("car constructor ...");
    }

    public void init(){
        System.out.println("car ... init ... ");
    }

    public void detory(){
        System.out.println("car ... detory ...");
    }
}
