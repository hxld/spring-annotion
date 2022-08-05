package com.atguigu.test;

import com.atguigu.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hxld
 * @create 2022-08-05 15:12
 */

public class IocTest_LifeCycle {
    @Test
    public void test01(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("ioc容器创建完成...");

        //针对多实例
//        applicationContext.getBean("car");

        //关闭容器后才销毁
        applicationContext.close();
    }
}
