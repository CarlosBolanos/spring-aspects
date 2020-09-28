package com.example.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

    @After("execution(* com.example.demo.aop.business.*.*(..))")
    public void after(JoinPoint joinPoint){
        LOGGER.info("Intercepted after method call {}", joinPoint);
    }
}
