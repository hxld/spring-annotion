package com.atguigu.config;

import com.atguigu.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author hxld
 * @create 2022-08-05 22:01
 */

/**
 * 自动装配：
 *      spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值；
 * @Autowired:自动注入：
 *      1）默认优先按照类型去容器中找对应的组件：applicationContext.getBean(BookDao.class);找到就赋值
 *      2)如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 *                      applicationContext.getBean("bookDao")
 *
 *            BookService bookService(){
 *                      BookDao bookDao;
 *                      }
 *      3)@Qualifier("bookDao"):使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 *      4)自动装配默认一定要将属性赋值好，没有就会报错。
 *      可以使用@Autowired(required = false)；
 *      5)@Primary:默认使用首选的bean.也可以使用@Qualifier指定默认使用哪个
 */
@Configuration
@ComponentScan({"com.atguigu.service","com.atguigu.dao","com.atguigu.controller"})
public class MainConfigOfAutowired {

//    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return  bookDao;
    }

}
