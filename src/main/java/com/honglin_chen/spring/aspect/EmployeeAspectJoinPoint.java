package com.honglin_chen.spring.aspect;

import java.util.Arrays; 

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspectJoinPoint {
	
	@Before("execution(public void com.honglin_chen.spring.model..set*(*))")
	public void loggingAdvice(JoinPoint joinPoint) {
		/* 可以将 JoinPoint 作为参数传入建议方法中并通过其得到方法署名或是目标 object */
		System.out.println("EmployeeAspectJoinPoint: 在执行 loggingAdvice 建议到方法: " + joinPoint.toString() + " 之前"); 
		System.out.println("EmployeeAspectJoinPoint: 传入的参数: " + Arrays.toString(joinPoint.getArgs()));
	}
	
	/* 通过 args() 为建议设置参数形式, 应用到 bean 中所有参数为单一字符串的方法上 */
	@Before("args(name)")
	public void logStringArguments(String name) {
		/* 对已经设置好的建议参数 type, 建议方法的参数需要与其匹配 */
		System.out.println("EmployeeAspectJoinPoint: 传入的字符参数: " + name); 
	}
}
