package com.honglin_chen.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAnnotationAspect {
	/**
	 * 创建自定义 Pointcut 注解 @Loggable 并在需要执行建议的方法上
	 * 标记其为该注解, 自定义注解可以对 bean 中的方法强制执行建议, 通
	 * 用注解则会应用到所有表达式匹配到的 bean 方法上
	 */
	@Before("@annotation(com.honglin_chen.spring.aspect.Loggable)")
	public void myAdvice() {
		/* 对于任意被 @Loggable 标记的 bean 方法都会执行该自定义的建议 */ 
		System.out.println("EmployeeAnnotationAspect: 在 setName() 方法上执行自定义的建议"); 
	}
}
