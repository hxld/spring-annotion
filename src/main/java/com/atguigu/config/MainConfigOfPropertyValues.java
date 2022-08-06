package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hxld
 * @create 2022-08-05 21:14
 */
//使用@propertySource读取外部配置文件中的k/v保存到运行的环境变量中;
// 加载完外部的配置文件以后使用${}取出配置文件的值
@PropertySource(value={"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person(){
        return new Person();
    }
}
