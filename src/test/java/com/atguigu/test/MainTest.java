package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.transform.Source;

/**
 * @author hxld
 * @create 2022-08-03 22:44
 */
public class MainTest {
    public static void main(String[] args) {

        //beans.xml配置方式的测试
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        //本来是object,然后强转为person
//        Person bean = (Person) applicationContext.getBean("person");
//        System.out.println(bean);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);


        //获取Person这个类型的组件在IOC容器中的名字
       String[] type = applicationContext.getBeanNamesForType(Person.class);
       for (String name: type) {
           System.out.println(name);

       }
    }
}
