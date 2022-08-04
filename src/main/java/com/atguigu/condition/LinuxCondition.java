package com.atguigu.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author hxld
 * @create 2022-08-04 22:58
 */
//判断是否为Linux系统
public class LinuxCondition  implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //1.可以获取到IOC使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        //2.获取类加载器
        ClassLoader classLoader = context.getClassLoader();

        //3. 获取当前环境信息
        Environment environment = context.getEnvironment();

        //4.获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        //5.可以判断容器中的bean注册情况，也可以给容器中注册bean
        boolean person = registry.containsBeanDefinition("person");


        String property = environment.getProperty("os.name");

        if(property.contains("linux")){
            return true;
        }



        return false;
    }
}
