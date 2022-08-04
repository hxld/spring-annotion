package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.*;

/**
 * @author hxld
 * @create 2022-08-03 22:50
 */
@Configuration
public class MainConfig2 {


    //prototype:多实例        ioc容器启动并不会去调用方法创建对象放到容器中，每次获取的时候才会调用方法创建对象，获取一次创建一次。
    //singleton：单实例（默认） ioc容器启动会调用方法创建对象放到Ioc容器中，以后每次获取就是直接从容器（相当于map.get()）中拿。
    //request:同一次请求创建一个实例   --- web工程中 -----基本不使用
    //session：同一个session创建一个实例   --- web工程中 -----基本不使用
    @Scope("prototype")   //调整作用域

    //默认是单实例对象
    @Bean("person")
    public  Person person(){
        //测试实例在多久创建，如下语句。
        System.out.println("给容器中添加person....");


        return new Person("张三",25);
    }

}
