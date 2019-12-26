package com.thinkingcao.springboot.aoplog.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;



/**
 * @desc: AOP切面模板
 * @author: cao_wencao
 * @date: 2019-12-26 16:18
 */
public class AopTempalate {

    //@Aspect 表明是一个切面类
    @Pointcut("execution(public * com.thinkingcao.springboot.aoplog.config.*.*(..))")
    public void LogAspect() {
    }

    //前置通知：目标方法执行之前执行以下方法体的内容
    @Before("LogAspect()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("doBefore");
    }

    //后置通知：目标方法执行之后执行以下方法体的内容，不管是否发生异常。
    @After("LogAspect()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("doAfter");
    }

    //返回通知：目标方法正常执行完毕时执行以下代码
    @AfterReturning("LogAspect()")
    public void doAfterReturning(JoinPoint joinPoint) {
        System.out.println("doAfterReturning");
    }

    //异常通知：在方法执行过程中抛出异常的时候执行
    @AfterThrowing("LogAspect()")
    public void deAfterThrowing(JoinPoint joinPoint) {
        System.out.println("deAfterThrowing");
    }

    //环绕通知： 在执行方法前后调用执行，这是最常用的方法
    @Around("LogAspect()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("deAround");
        //放行
        Object object = joinPoint.proceed();
        return object;
    }
}
