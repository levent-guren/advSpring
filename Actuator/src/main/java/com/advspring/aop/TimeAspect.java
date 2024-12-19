package com.advspring.aop;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.advspring.actuator.ActuatorInfo;

@Component
@Aspect
public class TimeAspect {
	@Around("execution(* com.advspring.controller.*.*(..)) && target(bean)")
	public Object calTime(ProceedingJoinPoint joinPoint, Object bean) throws Throwable {
		String className = bean.getClass().getName();
		String functionName = joinPoint.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object result = joinPoint.proceed();
		stopWatch.stop();
		double time = stopWatch.lastTaskInfo().getTime(TimeUnit.SECONDS);
		ActuatorInfo.addTime(className + ":" + functionName, time);
		return result;
	}

}
