package com.atguigu.test;

import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.bean.Yellow;
import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.config.MainConfigOfProfile;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author hxld
 * @create 2022-08-05 15:12
 */

public class IocTest_Profile {

    //1.运行时在命令行参数中动态设置：虚拟机参数位置加载：-Dspring.profiles.active=test (dev   prod)
    @Test
    public void test01(){

//        AnnotationConfigApplicationContext applicationContext =
//                new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        // 方式2 使用代码方式
//        1.创建一个applicationContext
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test","dev");
        //3.注册配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4.启动刷新容器
        applicationContext.refresh();
        //方式2


        Yellow bean = applicationContext.getBean(Yellow.class);
        System.out.println(bean);

        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String name : namesForType){
            System.out.println(name);
        }
        }
    }

