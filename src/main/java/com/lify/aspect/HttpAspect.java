package com.lify.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.lify.controller.GirlController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("before logger info");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //body
        logger.info("attributes={}", joinPoint.getArgs());
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + '.' + joinPoint.getSignature().getName());
        //ip
        logger.info("ip={}", request.getRemoteAddr());

        logger.info("body={}", request.getParameterMap());
    }

    @After("log()")
    public void logAfter() {
        logger.info("after logger info");
    }

    @AfterReturning(returning = "object", pointcut = "log()")//只填一个，默认 是 string，代表pointcut
    public void doAfterReturning(Object object) {
//        logger.info("response={}", object);
    }

}
