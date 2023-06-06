package edu.miu.restful.aspect;

import edu.miu.restful.entity.Logger;
import edu.miu.restful.entity.dto.LoggerDto;
import edu.miu.restful.service.LoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class ExecutionTimeAspect {
    private final LoggerService loggerService;

    @Autowired
    ModelMapper modelMapper;

    public ExecutionTimeAspect(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @Pointcut("@annotation(edu.miu.restful.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        Date curr = new Date();
        Logger log = new Logger(curr, finish-start, "John", proceedingJoinPoint.getSignature().getName());
        loggerService.save(modelMapper.map(log, LoggerDto.class));
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + (finish - start));
        return result;
    }
}
