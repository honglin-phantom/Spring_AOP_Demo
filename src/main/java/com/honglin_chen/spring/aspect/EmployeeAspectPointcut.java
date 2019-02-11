package com.honglin_chen.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeAspectPointcut {
	/* 对当前的 @Before 建议, 我们使用自定义的 Pointcut 方法作为其表达式
	 * 即在 getName() 方法上执行 loggingAdvice 建议 
	 */
	@Before("getNamePointcut()")
	public void loggingAdvice(){
		System.out.println("EmployeeAspectPointcut: 在 getName() 上执行 loggingAdvice 建议");
	}
	
	@Before("getNamePointcut()")
	public void secondAdvice(){
		System.out.println("EmployeeAspectPointcut: 在 getName() 上执行 secondAdvice 建议");
	}
	
	/* 定义一个 Pointcut 表达式方法, 当我们在多处地方使用 Pointcut 表达式时
	 * 可以同过该方法来代替较长的表达式
	 */
	@Pointcut("execution(public String getName())")
	public void getNamePointcut(){}
	
	@Before("allMethodsPointcut()")
	public void allServiceMethodsAdvice(){
		System.out.println("EmployeeAspectPointcut: 在执行所有服务类方法之前");
	}
	
	/* 在服务包中的所有类的方法上执行当前定义的 Pointcut 表达式 */
	@Pointcut("within(com.honglin_chen.spring.service.*)")
	public void allMethodsPointcut(){}
}
