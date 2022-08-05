package com.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author hxld
 * @create 2022-08-05 11:51
 */
//创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean {

    //返回一个Color对象，这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean....getObject");
        return new Color();
    }

    //返回的类型
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    //是单例？
    //true:这个bean 是单实例，在容器中保存一份
    //false：多实例，每次获取都会创建一个新的bean;
    @Override
    public boolean isSingleton() {
//        return FactoryBean.super.isSingleton();
        return true;
//        return  false;
    }
}
