package com.atguigu.config;

import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
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
 * 1）
 * @Autowired:自动注入：(构造器、方法、属性、参数)
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
 *
 *   2）spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
 *      @Resource:
 *              可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的；
 *              没有能支持@Primary功能，没有支持@Autowired(required = false)；
 *      @Inject：
 *              需要导入javax.inject的包，和Autowires的功能一样，支持@Primary，只不过接口里没有任何方法（比如说@Autowired(required = false)）
 *
 * 3）@Autowired：构造器，参数，方法，属性；都是从容器中获取参数组件的值
 *      1.标注在方法位置 : @Bean + 方法参数；参数从容器中获取 默认不写@Autowired效果是一样的；都能自动装配
 *      2.标在构造器上：如果组件中只有一个有参构造器，那么构造器处的@Autowired可以省略，因为参数位置的组件还是从容器中获取
 *      3.放在参数位置；
 */
@Configuration
@ComponentScan({"com.atguigu.service","com.atguigu.dao","com.atguigu.controller","com.atguigu.bean"})
public class MainConfigOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return  bookDao;
    }

    /**
     * @Bean标注的方法创建对象的时候，方法参数的值从容器中获取
     * @param car
     * @return
     */
    @Bean
    public Color color(Car car){
         Color color = new Color();
        color.setCar(car);
        return color;

    }

}
