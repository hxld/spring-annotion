package com.atguigu.config;

/**
 * @author hxld
 * @create 2022-08-07 14:37
 */

import com.atguigu.aop.LogAspects;
import com.atguigu.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP:动态代理
 *      指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 *
 *      步骤:
 *      1.导入aop模块：Spring AOP (spring-aspects)
 *      2.定义一个业务逻辑（MathCalculator）;在业务逻辑运行的时候将日志进行打印（方法钱前、方法运行时、方法运行之后）
 *      3.定义一个日志切面类（LogAspects）:切面里面的方法需要动态感知MathCalculator.div运行到哪里了
 *              通知方法：
 *                      前置通知（@Before）:logStart :在目标方法（div）运行之前运行
 *                      后置通知（@After）:logEnd:在目标方法（div）运行结束之后运行（无论是正常结束还是异常结束）
 *                      返回通知（@AfterReturning）:logReturn:在目标方法（div）正常返回之后运行
 *                      异常通知（@A福特人Throwing）：logException:在目标方法（div）出现异常以后运行
 *                      环绕通知（@Around）动态代理，手动推进目标方法运行（joinPoint.procced()）
 *       4.给切面类的目标犯法标注何时何地运行(通知注解)
 *       5.将切面类和业务逻辑类（目标方法所在类）都加入到容器中；
 *       6.必须告诉Spring哪个类是切面类（给切面类加上一个注解：@Aspect）
 *       7.给配置类中加@EnableAspectJAutoProxy  ---开启基于注解的aop模式
 *                      在spring中很多的@Enablexxx
 *       归纳总结三步：
 *          1.将业务逻辑组件和切面类都加入到容器中，告诉spring哪个是切面类（@Aspect）
 *          2.在切面类上的每一个通知方法上标注注解，告诉SPRING何时何地运行（切入点表达式）
 *          3.开启基于注解的aop模式；
 *
 *
 * AOP原理：（看给容器中注册了什么组件，这个组件什么时候工作，这个组件的功能）
 *          @EnableAspectJAutoProxy;
 *      1.@EnableAspectJAutoProxy是什么？
 *              @Import({AspectJAutoProxyRegistrar.class}):给容器中导入AspectJAutoProxyRegistrar
 *              利用AspectJAutoProxyRegistrar给容器中注册bean;
 *              internalAutoProxyCreator = AnnotationAwareAspectJAutoProxyCreator.
 *
 *              给容器中注册一个AnnotationAwareAspectJAutoProxyCreator；
 *       2.AnnotationAwareAspectJAutoProxyCreator
 *            ->AspectJAwareAdvisorAutoProxyCreator
 *              -> AbstractAdvisorAutoProxyCreator
 *                 -> AbstractAutoProxyCreator
 *                    implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *                      -> InstantiationAwareBeanPostProcessor
 *                         -> BeanPostProcessor  后置处理器（在bean初始化前后完成做的事情） 自动注入BeanFactory
 *
 */

@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAOP {
    //业务逻辑加入到容器中
    @Bean
    public MathCalculator mathCalculator(){
        return  new MathCalculator();
    }

    //切面类
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

}
