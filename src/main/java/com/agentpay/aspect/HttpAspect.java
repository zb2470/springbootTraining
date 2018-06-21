package com.agentpay.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpAspect {
    private static Logger logger=LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.agentpay.controller.*.*(..))")
    public void log(){

    }

    public void doBefore(JoinPoint joinPoint){


    }

}
