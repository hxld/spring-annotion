package com.atguigu.condition;

import com.atguigu.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author hxld
 * @create 2022-08-05 10:54
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     AnnotationMetadata: 当前类的注解信息
     BeanDefinitionRegistry:BeanDefinition注册类
     把所有需要添加到容器中的bean;
     调用：BeanDefinitionRegistry.registerBeanDefinition 手工注册进来。
     */
   @Override
    public  void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry){
       //判断是否有下面两个组件
       boolean definition = registry.containsBeanDefinition("com.atguigu.bean.Red");
       boolean definition1 = registry.containsBeanDefinition("com.atguigu.bean.Blue");
       //如果有
       if(definition && definition1){
           //指定bean的定义信息（Bean类型）
           RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
           //进行注册bean名：rainBow
           registry.registerBeanDefinition("rainBow",beanDefinition);
       }


   }

}
