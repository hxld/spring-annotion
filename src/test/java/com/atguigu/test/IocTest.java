package com.atguigu.test;

import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hxld
 * @create 2022-08-04 12:46
 */
public class IocTest {

    @Test
   public  void test01(){

       AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
      //查看bean容器中所有的组件，输出名字
       String[] names = applicationContext.getBeanDefinitionNames();
       for (String name: names) {
           System.out.println(name);

       }
   }



    @Test
    public  void test02(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        //查看bean容器中所有的组件，输出名字
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name: names) {
            System.out.println(name);

            //ioc容器创建完成（测试多实例对象在何时被创建）
            System.out.println("ioc容器创建完成......");
            //测试@bean给我们创建的是单实例对象
            //第一次获取
            Object bean = applicationContext.getBean("person");
            //第二次获取
            Object bean2 = applicationContext.getBean("person");
            //判断这两个对象是否相等
            System.out.println(bean == bean2);
            //结果为true，即默认是单实例的
            //当我们设置@Scope("prototype")时，结果为false，即不是同一个对象，多实例

        }
    }
}
