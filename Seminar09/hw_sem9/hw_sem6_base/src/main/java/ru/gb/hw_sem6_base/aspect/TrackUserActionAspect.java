package ru.gb.hw_sem6_base.aspect;

import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
@Aspect
@Component
public class TrackUserActionAspect {
    @Around(value = "@annotation(TrackUserAction)")
    public Object log(ProceedingJoinPoint joinPoint)  throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object returnedByMethod = joinPoint.proceed();
        System.out.println("User called the method " + methodName);
        return returnedByMethod;
    }
}
