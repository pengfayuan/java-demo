package com.yuanyuan.javademo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author FAYUAN.PENG
 * @version \$Id: MethodTimeCalcAspect.java,  2021-01-21 23:03 FAYUAN.PENG Exp $$
 */
@Aspect
@Component
public class MethodTimeCalcAspect {

    @Pointcut("execution(* com.yuanyuan.javademo.job.CleanLogJob.*(..) )")
    public void calcMethodTime() {
    }

    @Pointcut("within(com.yuanyuan.javademo.job.SuperJob+)")
    public void calcMethodTime2() {
    }

    /**
     * 前置通知，在调用目标方法前调用
     */
    @Before("calcMethodTime()")
    public void before() {
        System.out.println("before ...");
    }

    /**
     * 后置通知，在调用目标方法后调用
     */
    @After("calcMethodTime()")
    public void after() {
        System.out.println("after ...");
    }

    @Around("calcMethodTime()")
    public void around(ProceedingJoinPoint point) {
        System.out.println("before ....");
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after ....");
    }

    @Around("calcMethodTime2()")
    public Object aroung2(ProceedingJoinPoint point) {
        Object result = null;
        System.out.println("before ....");
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after ....");
        return result;
    }
}
