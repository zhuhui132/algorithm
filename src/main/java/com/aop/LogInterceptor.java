package com.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
    @Pointcut("execution(public * net.aazj.service..*.getUser(..))")
    public void myMethod(){};


    @Before("myMethod()")
    public void before() {
        System.out.println("method start");
    }
    @After("myMethod()")
    public void after() {
        System.out.println("method after");
    }
    @AfterReturning("execution(public * net.aazj.mapper..*.*(..))")
    public void AfterReturning() {
        System.out.println("method AfterReturning");
    }
    @AfterThrowing("execution(public * net.aazj.mapper..*.*(..))")
//  @Around("execution(public * net.aazj.mapper..*.*(..))")
    public void AfterThrowing() {
        System.out.println("method AfterThrowing");
    }
    @Around("execution(public * net.aazj.mapper..*.*(..))")
    public Object Around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("method Around");
        SourceLocation sl = jp.getSourceLocation();
        Object ret = jp.proceed();
        System.out.println(jp.getTarget());
        return ret;
    }
    @Before("execution(public * net.aazj.service..*.getUser(..)) && args(userId,..)")
    public void before3(int userId) {
        System.out.println("userId-----" + userId);
    }
    @Before("myMethod()")
    public void before2(JoinPoint jp) {
        Object[] args = jp.getArgs();
        System.out.println("userId11111: " + (Integer)args[0]);
        System.out.println(jp.getTarget());
        System.out.println(jp.getThis());
        System.out.println(jp.getSignature());
        System.out.println("method start");
    }
}





