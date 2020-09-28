package com.example.demo.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionAspect {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

//    @Around("execution(* com.example.demo.aop.business.*.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        LOGGER.info("Proceedings startTime  {}", startTime);
        LOGGER.info("joinPoint {} ", joinPoint.getSignature().getName());
        joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        LOGGER.info("Proceedings around method call {} {}", joinPoint, timeTaken);
    }
}
