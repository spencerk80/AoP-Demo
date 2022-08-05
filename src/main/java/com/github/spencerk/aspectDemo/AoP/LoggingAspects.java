package com.github.spencerk.aspectDemo.AoP;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspects {
    private static final Logger logger = LogManager.getLogger();
    @Before("execution(* com.github.spencerk.aspectDemo.prompt.*.*(..))")
    public void logEntry(JoinPoint joinPoint) {
        logger.info(String.format("Entry: %s -> %s\n", joinPoint.getTarget(), joinPoint.getSignature()));
    }

    @After("execution(* com.github.spencerk.aspectDemo.prompt.*.*(..))")
    public void logExit(JoinPoint joinPoint) {
        logger.info(String.format("Exit from: %s -> %s\n", joinPoint.getTarget(), joinPoint.getSignature()));
    }

    @AfterReturning(pointcut="execution(* com.github.spencerk.aspectDemo.prompt.*.*(..))", returning="returned")
    public void logReturn(Object returned) {
        logger.info(String.format("Return: %s\n", returned));
    }
}
