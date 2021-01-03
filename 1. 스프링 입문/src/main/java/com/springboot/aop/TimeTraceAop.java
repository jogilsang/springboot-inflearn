package com.springboot.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    // com.springboot 패키지 하위 다 적용
    // 컨디션 조절가능
    @Around("execution(* com.springboot..*(..))")
    // @Around("execution(* com.springboot.service..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());

        try {
            // joinpoint로 메소드 호출할때마다, 인터셉트가 걸림
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
        }


    }


}
