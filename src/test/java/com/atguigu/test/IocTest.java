package com.atguigu.test;

import com.atguigu.bean.ColorFactoryBean;
import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @author hxld
 * @create 2022-08-04 12:46
 */
public class IocTest {

    @Test
    public void test01() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //查看bean容器中所有的组件，输出名字
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);

        }
    }


    @Test
    public void test02() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        //查看bean容器中所有的组件，输出名字
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
            //ioc容器创建完成（测试多实例对象在何时被创建）
            System.out.println("ioc容器创建完成......");
//            //测试@bean给我们创建的是单实例对象
//            //第一次获取
            // Object bean = applicationContext.getBean("person");
//            //第二次获取
//            Object bean2 = applicationContext.getBean("person");
//            //判断这两个对象是否相等
//            System.out.println(bean == bean2);
//            //结果为true，即默认是单实例的
//            //当我们设置@Scope("prototype")时，结果为false，即不是同一个对象，多实例


    }


    @Test
    public void test03() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        //获取当前操作环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值
        String property = environment.getProperty("os.name");
        System.out.println(property);

        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }

        //获取所有对象
        Map<String, Person> personMap = applicationContext.getBeansOfType(Person.class);
        System.out.println(personMap);


    }


    //抽取出一个通用的打印配置类中所有组件的方法
    public void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
       @Test
        public void testImport(){
            AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
            printBeans(applicationContext);

            //工厂Bean获取的是调用getObject创建对象
           //获取的类型：Color
           Object bean = applicationContext.getBean("colorFactoryBean");
           //获取的类型：Color
           Object bean2 = applicationContext.getBean("colorFactoryBean");

           //获取的类型：ColorFactoryBean 加一个前缀& 获取工厂Bean本身
           Object bean3 = applicationContext.getBean("&colorFactoryBean");

           System.out.println("bean的类型"+bean.getClass());
           System.out.println("bean3的类型"+bean3.getClass());
           System.out.println(bean == bean2);
       }
    }


