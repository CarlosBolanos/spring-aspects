package com.example.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ErrorHandlingAspect {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

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
        LOGGER.info("Intercepted thrown call {} with value {}", joinPoint, exception.getMessage());
    }
}
