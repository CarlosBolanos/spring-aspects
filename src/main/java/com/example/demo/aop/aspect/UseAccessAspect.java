package com.example.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UseAccessAspect {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.demo.aop.business.*.*(..))")
    public void before(JoinPoint joinPoint){
        LOGGER.info("Intercepted before method call {}", joinPoint);
    }

    @AfterReturning(
        value="execution(* com.example.demo.aop.business.*.*(..))",
        returning="result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result){
        LOGGER.info("Intercepted after returning method call {} with value {}", joinPoint, result);
    }

    @AfterThrowing(
        value="execution(* com.example.demo.aop.business.*.*(..))",
        throwing="exception"
    )
    public void afterThrowing(JoinPoint joinPoint, Throwable exception){
        LOGGER.info("Intercepted thrown call {} with value {}", joinPoint, exception);
    }

    @After("execution(* com.example.demo.aop.business.*.*(..))")
    public void after(JoinPoint joinPoint){
        LOGGER.info("Intercepted after method call {}", joinPoint);
    }


}
