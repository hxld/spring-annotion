package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfigOfLifeCycle;
import com.atguigu.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Period;

/**
 * @author hxld
 * @create 2022-08-05 15:12
 */

public class IocTest_PropertyValue {

    //抽取出一个通用的打印配置类中所有组件的方法
    public void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
    @Test
    public void test01(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        printBeans(applicationContext);
        System.out.println("=====================");

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        //也可以从当前环境中获取，因为这些信息都加载到当前环境中了
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

    }


}
