package com.atguigu.config;

import com.atguigu.bean.Color;
import com.atguigu.bean.Person;
import com.atguigu.bean.Red;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @author hxld
 * @create 2022-08-03 22:50
 */
@Configuration

//类中注解统一设置  放在类上，只有当条件匹配成功后，类中的所有的bean才会被注册
@Conditional({WindowsCondition.class})
//导入组件，id默认是组件的全类名
@Import({Color.class, Red.class})
public class MainConfig2 {


    //prototype:多实例        ioc容器启动并不会去调用方法创建对象放到容器中，每次获取的时候才会调用方法创建对象，获取一次创建一次。
    //singleton：单实例（默认） ioc容器启动会调用方法创建对象放到Ioc容器中，以后每次获取就是直接从容器（相当于map.get()）中拿。
    //request:同一次请求创建一个实例   --- web工程中 -----基本不使用
    //session：同一个session创建一个实例   --- web工程中 -----基本不使用
   // @Scope("prototype")   //调整作用域

    @Lazy    // 懒加载  ：容器启动不创建对象，第一次使用（获取）Bean创建对象，并初始化
    //默认是单实例对象
    @Bean("person")
    public  Person person(){
        //测试实例在多久创建，如下语句。
        System.out.println("给容器中添加person....");
        return new Person("张三",25);
    }


    /**
     * @Conditional ({Condition}):按照一定的条件进行判断，满足条件给容器中注册Bean
     * //如果当前IOC容器操作环境是windows系统，则给容器中注册bill
     * //如果当前IOC容器操作环境是LINXU系统，则给容器中注册linus
     */
    @Conditional({WindowsCondition.class})  //放在方法上，条件是对方法有用。
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus",48);
    }


    /**
     * 给容器中注册组件：
     * 1.包扫描+组件标注注解（@Controller/@Service/@Reposity/@Component ） ----局限于我们自己创建的类
     * 2.@Bean(导入的第三方包里面的组件)
     * 3.@Import(快速给容器中导入一个组件)
     */
}
