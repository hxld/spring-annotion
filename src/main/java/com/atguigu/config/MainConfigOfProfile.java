package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.bean.Yellow;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.EmbeddedValueResolver;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * @author hxld
 * @create 2022-08-06 14:36
 */

/**
 * Profile :
 *          Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能；
 *
 * 开发环境、测试环境、生产环境；
 * 数据源（/A/B/C）
 * @Profile:指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境都能注册这个组件。
 *
 *1)加了环境标识的bean,只有这个环境被激活的时候才能注册到容器中，默认是default环境
 *2)写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3)没有标注环境表示的bean在任何环境下都是会被加载的
 *
 */
// /表示从类路径下开始寻找
@PropertySource("classpath:/jdbc.properties")
@Configuration
//@Profile("prod")   加载在配置类上，对整个类都有管理作用
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

//    使用jdbc.properties的几种方式方式，取出其中值
    //方式1 使用属性+ @Value注解
    @Value("${jdbc.user}")
    private  String user;

    //方式三 ：使用值解析器
    private StringValueResolver valueResolver;
    private String driverClass;

//    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

    @Profile("test")
    @Bean("testDataSource")
    //方式2 使用参数+@Value注解
    public DataSource dataSourceTest(@Value("${jdbc.password}") String pwd) {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUsername("user");  方式1
        dataSource.setUsername(user);
//        dataSource.setPassword("abc123"); 方式2
        dataSource.setPassword(pwd);
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver"); 方式3
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl("jdbc:mysql://localhost:13306/test");
        return dataSource;
    }

    @Profile("dev")
    @Bean("DevDataSource")
    public DataSource dataSourceDev(@Value("${jdbc.password}") String pwd) {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUsername("user");
        dataSource.setUsername(user);
//        dataSource.setPassword("abc123");
        dataSource.setPassword(pwd);
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl("jdbc:mysql://localhost:13306/atguigudb");
        return dataSource;
    }

    @Profile("prod")
    @Bean("ProdDataSource")
    public DataSource dataSourceProd(@Value("${jdbc.password}") String pwd) {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUsername("user");
        dataSource.setUsername(user);
//        dataSource.setPassword("abc123");
        dataSource.setPassword(pwd);
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl("jdbc:mysql://localhost:13306/bookdb");
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
        driverClass = valueResolver.resolveStringValue("${jdbc.driverClassName}");

    }
}