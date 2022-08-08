package com.atguigu.tx;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author hxld
 * @create 2022-08-08 10:30
 */

/**
 * 声明式事务：
 *      环境搭建：
 *      1.导入相关依赖
 *              数据源、数据库驱动、spring-jdbc模块
 *      2.配置数据源、JdbcTemplate(Spring提供的简化数据库操作的工具)操作数据库
 *      3.给方法上标注@Transactional表示当前方式是一个书屋方法；
 *      4.@EnableTransactionManagement  开启基于注解的事务管理功能
 *                  @Enablexxx
 *      5.配置事务管理器来控制事务
 *                      @Bean
 *                          public PlatformTransactionManager platformTransactionManager()
 */
@EnableTransactionManagement
@ComponentScan("com.atguigu.tx")
@Configuration
public class TxConfig {

    //数据源
    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("abc123");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:13306/test");
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        //spring对@ Configuration类会特殊处理；给容器中加组件的方法，多次调用都只是从容器中获取
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    //注册事务管理器在容器中
    @Bean
    public PlatformTransactionManager platformTransactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
