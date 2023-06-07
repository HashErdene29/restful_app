package edu.miu.restful.aspect;

import edu.miu.restful.entity.Logger;
import edu.miu.restful.entity.dto.LoggerDto;
import edu.miu.restful.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggerAspect {
    private final LoggerService loggerService;
    long start;
    long finish;

    @Autowired
    ModelMapper modelMapper;

    public LoggerAspect(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    //This point cut will execute where ever the annotation is placed
    @Pointcut("@annotation(edu.miu.restful.aspect.annotation.LogMe)")
    public void logMeAnnotation(){}

    //    @Before("logMeAnnotation()")
//    public void logBeforeByAnnotation(JoinPoint joinPoint){
//        System.out.println("Log before the method: " + joinPoint.getSignature().getName());
//    }
//
//    @After("logMeAnnotation()")
//    public void logAfterByAnnotation(JoinPoint joinPoint){
//        System.out.println("Log after the method: " + joinPoint.getSignature().getName());
//    }

    // This point cut will execute according to the given designations
    @Pointcut("execution( * edu.miu.restful.controller.UserController.*(..))")
    public void logMe() {
    }

//    @Pointcut("@args(edu.miu.springaop.aspect.annotation.LogMe)")
//    public void logMeAnnotation2() {
//
//    }

//    // This point cut will execute according to the given designations
//    @Pointcut("target(edu.miu.springaop.controller.ProductController)")
//    public void logMe() {
//    }

//    // This point cut will execute according to the given designations
//    @Pointcut("execution( * *.*.*(..))")
//    public void logMe() {
//    }

//    // This point cut will execute according to the given designations //  edu.miu.springaop
//    @Pointcut("within(edu.miu.springaop.controller.ProductController)")
//    public void logMe() {
//    }


    @Before("logMe()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Log before the method: " + joinPoint.getSignature().getName());
    }

    @After("logMe()")
    public void logAfter(JoinPoint joinPoint) {
        start = System.nanoTime();
        System.out.println("Log after the method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("logMe()")
    public void logAfterReturning(JoinPoint joinPoint) {
        finish = System.nanoTime();
        Logger log = new Logger(new Date(), finish - start, "John", joinPoint.getSignature().getName());
        loggerService.save(modelMapper.map(log, LoggerDto.class));
        System.out.println("Log after returned the method: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("logMe()")
    public void logAfterThrowing(JoinPoint joinPoint) {
        System.out.println("Log after throwing the method: " + joinPoint.getSignature().getName());
    }

//    @Around("execution(* edu.miu.restful.controller.UserController.*(..))")
//    public void logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("BEFORE Log around:" + proceedingJoinPoint.getSignature().getName());
//        proceedingJoinPoint.proceed();
//        System.out.println("AFTER Log around:" + proceedingJoinPoint.getSignature().getName());
//    }
}
