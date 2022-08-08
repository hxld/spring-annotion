package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import com.atguigu.tx.TxConfig;
import com.atguigu.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @author hxld
 * @create 2022-08-04 12:46
 */
public class IocTest_tx {

    @Test
    public void test01() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService service = applicationContext.getBean(UserService.class);
        service.insertUser();
        applicationContext.close();

    }
}

