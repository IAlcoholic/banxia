package me.scxubo.banxia.utils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;


/*
* aop处理请求，记录日志
* */
@Aspect
@Component
public class HttpAspect {
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * me.scxubo.banxia.controller..*.*(..))")
    public void log(){

    }

    /**
     *
     * @param joinPoint
     */
    @Before("log()")
    public void Before(JoinPoint joinPoint){

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info( "━━━━━━━━━━━━━━━━━━━━请求信息━━━━━━━━━━━━━━━━━━━━━━━" );

        // 记录下请求内容
        logger.info("url  : " + request.getRequestURL().toString());
        logger.info("method   : " + request.getMethod());
        logger.info("ip  : " + request.getRemoteAddr());
        logger.info("类方法  : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("参数  : " + Arrays.toString(joinPoint.getArgs()));

        //获取所有参数方法一：
        Enumeration<String> enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            System.out.println(paraName+": "+request.getParameter(paraName));
        }
    }


    @After("log()")
    public void After(){

    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturning(Object result) {
        logger.info( "━━━━━━━━━━━━━━━━━━━━返回结果━━━━━━━━━━━━━━━━━━━━━━━" );
            System.out.println( result);
        logger.info( "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" );

    }

}