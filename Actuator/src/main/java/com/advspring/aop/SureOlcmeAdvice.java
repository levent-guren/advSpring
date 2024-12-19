package com.advspring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SureOlcmeAdvice {
	@Before("execution(* com.advspring.controller.*.*(..)) && target(bean)")
	public void log(JoinPoint jp, Object bean) {
		System.out.println("Loglama çağırıldı");
		System.out.println("Target: " + bean.getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());
	}

}
