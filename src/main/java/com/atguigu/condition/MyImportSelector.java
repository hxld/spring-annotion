package com.atguigu.condition;

import com.atguigu.bean.Blue;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author hxld
 * @create 2022-08-05 10:40
 */

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {
    //返回值，就是要导入到容器中的组件全类名
    //AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.atguigu.bean.Blue","com.atguigu.bean.Yellow"};
    }
}
