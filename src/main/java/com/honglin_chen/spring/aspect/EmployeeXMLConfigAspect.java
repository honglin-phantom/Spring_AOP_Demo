package com.honglin_chen.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/* 通过 Spring 构造文件构造 Aspects 而非通过注解的方式 */ 
public class EmployeeXMLConfigAspect {
	
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("EmployeeXMLConfigAspect:: 执行 getName() 方法之前");
		
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("EmployeeXMLConfigAspect:: 执行 getName() 方法之后返回的值是: " + value);
		
		return value;
	}
}