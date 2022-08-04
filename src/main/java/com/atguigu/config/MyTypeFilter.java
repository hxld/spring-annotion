package com.atguigu.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author hxld
 * @create 2022-08-04 17:27
 */
// FilterType 的自定义规则
public class MyTypeFilter implements TypeFilter {
    //match方法返回值是布尔类型，如果是true--匹配成功，false--匹配失败
    //metadataReader ----读取到的当前正在扫描的类的信息
    //metadataReaderFactory -----可以获取到其他任何类信息的
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的信息(接口、类型等)
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源（类的路径）
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("------->" + className);


        //自定义过滤规则,service,controller中就包含er
        if(className.contains("er")){
            return  true;
        }

        //false表示一个都不匹配，即一个都不扫描
        return false;
    }
}
