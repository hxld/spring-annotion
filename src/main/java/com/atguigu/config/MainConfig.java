package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author hxld
 * @create 2022-08-03 22:50
 */
//配置类 == 配置文件（beans.xml）
//告诉spring这是一个配置类
@Configuration


//@ComponentScan(value="com.atguigu")
//设置哪些不扫描  excludeFilters = filter[] 指定扫描的时候按照什么规则排除哪些组件，不包含哪些组件
//type是指按哪种类型来进行过滤，classes为一个数组，里面为具体的过滤条件实体。
//@ComponentScan(value="com.atguigu",excludeFilters = {
//       @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Service.class})
//})
//includeFilter =filter[] 只包含哪些组件,必须设置useDefaultFilters = false，禁用默认全局扫描
//@ComponentScan(value="com.atguigu",includeFilters = {
//            @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
//},useDefaultFilters = false )

//设置多个扫描策略
//@ComponentScans(
//        value={ @ComponentScan(value="com.atguigu",includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
//        },useDefaultFilters = false )
//        ,@ComponentScan(value="com.atguigu",excludeFilters = {
//                @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Service.class})
//        })}
//)


/*      FilterType
        ANNOTATION ：按照注解
        ASSIGNABLE_TYPE ：按照指定类型 ，比如说classes={BookService.class}
        ASPECTJ:基本不用
        REGEX：按照正则表达式
        CUSTOM：按照自定义规则。需要我们创建一个 TypeFilter的实现类

 */
// FilterType 的自定义规则
@ComponentScan(value="com.atguigu",includeFilters = {
            @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false )


public class MainConfig {

    //给容器中注册一个bean ,对应beans.xml中的bean。类型：返回值类型，id：方法名
   //value可以写person
    @Bean( "person01")
    public Person person() {
        return new Person("lisi",20);
    }
}
