package com.atguigu.test;

import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.dao.BookDao;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hxld
 * @create 2022-08-05 15:12
 */

public class IocTest_Autowired {
    @Test
    public void test01(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        BookService bookService = applicationContext.getBean(BookService.class);

        System.out.println(bookService);
//
//        BookDao bean = applicationContext.getBean(BookDao.class);
//        System.out.println(bean);
        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);


        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);

        applicationContext.close();
    }
}
