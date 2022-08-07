package com.atguigu.aop;

/**
 * @author hxld
 * @create 2022-08-07 14:44
 */
public class MathCalculator {

    public int div(int i,int j){
        System.out.println("方法被调用......");
        return i/j;
    }
}
