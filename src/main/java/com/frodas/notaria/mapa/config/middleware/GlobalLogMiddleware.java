package com.frodas.notaria.mapa.config.middleware;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class GlobalLogMiddleware {

    private final ObjectMapper objectMapper;

    @Around("execution(* com.frodas.notaria.mapa.presentation.controller.*.*(..))")
    public Object handler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("Before invoking controller: " + objectMapper.writeValueAsString(proceedingJoinPoint.getArgs()));
        Object value = proceedingJoinPoint.proceed();
        log.info("After invoking controller. Return value=" + objectMapper.writeValueAsString(value));
        return value;
    }

}