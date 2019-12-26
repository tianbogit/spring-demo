package com.example.aop.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Modifier;

@Aspect
@Component
@Order(2)
public class aopAspect2 {

    @Pointcut("execution(* com.example.aop.aopdemo.*.*(..))")
    public void declareJoinPointerExpression() {
    }

    /**
     * 前置方法,在目标方法执行前执行
     *
     * @param joinPoint 封装了代理方法信息的对象,若用不到则可以忽略不写
     */
    @Before("declareJoinPointerExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println(aopAspect2.class);
    }

    /**
     * 环绕方法,可自定义目标方法执行的时机
     *
     * @param pjd JoinPoint的子接口,添加了
     *            Object proceed() throws Throwable 执行目标方法
     *            Object proceed(Object[] var1) throws Throwable 传入的新的参数去执行目标方法
     *            两个方法
     * @return 此方法需要返回值, 返回值视为目标方法的返回值
     */
    @Around("declareJoinPointerExpression()")
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        Object result = null;

        try {
            //前置通知
            System.out.println("aopAspect2.class目标方法执行前...");
            //执行目标方法
            //result = pjd.proeed();
            //用新的参数值执行目标方法
            result = pjd.proceed(new Object[]{"newSpring2", "newAop2"});
            //返回通知
            System.out.println("aopAspect2.class目标方法返回结果后:" + result);
        } catch (Throwable e) {
            //异常通知
            System.out.println("aopAspect2.class执行目标方法异常后...");
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("aopAspect2.class目标方法执行后...");

        return result;
    }

    @After("declareJoinPointerExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        //获取当前请求对象
        System.out.println(aopAspect2.class);
    }
}
