package com.honglin_chen.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect; 
import org.aspectj.lang.annotation.After; 
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
public class EmployeeAfterAspect {
	@After("args(name)")
	public void logStringArguments(String name) {
		System.out.println("EmployeeAfterAspect: 执行 @After 建议. 传入的字符串参数: " + name);
	}
	
	/* 在 Employee 类的范围内, 当throwException() 抛出 exception 之后 */
	@AfterThrowing("within(com.honglin_chen.spring.model.Employee)")
	public void logExceptions(JoinPoint joinPoint) {
		/* 将 @AfterThrowing 建议执行到参数设置的方法上并通过 JoinPoint 将其方法署名输出 */
		System.out.println("EmployeeAfterAspect: 员工类中被抛出的 Exception: " + joinPoint.toString());
	}
	
	@AfterReturning(pointcut="execution(* getName())", returning="returnString")
	public void getNameReturningAdvice(String returnString) {
		/* pointcut 表达式匹配需要切入的点(方法) */ 
		/* 建议参数设置返回的数值 */ 
		System.out.println("EmployeeAfterAspect: getNameReturningAdvice() 建议被执行. 返回的字符串: " + returnString);
	}
}
