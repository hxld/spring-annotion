package com.atguigu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/** 切面类
 * @author hxld
 * @create 2022-08-07 14:47
 */
@Aspect   // 告诉spring这是一个切面类
public class LogAspects {

    /**
     * 抽取公共的切入点表达式
     * 1.在本类引用 ------ @Before("pointCut()")   写类名
     * 2.其他的切面引用  ------ @After("com.atguigu.aop.LogAspects.pointCut()") 写全类名
     *
     */
    @Pointcut("execution(public int com.atguigu.aop.MathCalculator.*(..))")
    public void pointCut(){};

    //@Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
    // @Before("public int com.atguigu.aop.MathCalculator.*(..)")
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();  // 拿到参数列表
//        System.out.println("除法运行。。。@Before参数列表是：{}");
        System.out.println(joinPoint.getSignature().getName()+"运行...@Before,参数列表是：{"+ Arrays.asList(args)+"}");
    }

    @After("com.atguigu.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
//        System.out.println("除法结束@After...");
        System.out.println(joinPoint.getSignature().getName()+"结束......@After");
    }

//    @AfterReturning("pointCut()")
    @AfterReturning(value="pointCut()",returning = "result")  //returning 来指定我们这个方法的参数谁来封装返回值
    // JoinPoint joinPoint ----必须出现在第一参数位置，否则运行报错
    public void logReturn(JoinPoint joinPoint,Object result){

//        System.out.println("除法正常返回...@AfterReturning运行结果是：{}");
        System.out.println(joinPoint.getSignature().getName()+"除法正常返回...@AfterReturning运行结果是：{"+result+"}");

    }

//    @AfterThrowing("pointCut()")
    @AfterThrowing(value="pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
//        System.out.println("除法异常...@AfterThrowing异常信息：{}");
        System.out.println(joinPoint.getSignature().getName()+"除法异常...@AfterThrowing异常信息：{"+exception+"}");
    }

}
