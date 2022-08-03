package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hxld
 * @create 2022-08-03 22:50
 */
//配置类 == 配置文件（beans.xml）
//告诉spring这是一个配置类
@Configuration
public class MainConfig {

    //给容器中注册一个bean ,对应beans.xml中的bean。类型：返回值类型，id：方法名
   //value可以写person
    @Bean("person")
    public Person person() {
        return new Person("lisi",20);
    }
}
