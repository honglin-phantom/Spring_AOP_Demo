package com.honglin_chen.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeAroundAspect {
	
	@Around("execution(* com.honglin_chen.spring.model.Employee.getName())")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		/**
		 * @Around 建议总是需要 ProceedingJoinPoint 作为参数, 因为我们需要 proceed()
		 * 方法去执行目标 object 的被建议执行的方法. 如果被建议执行到的方法返回, 建议会将
		 * 其返回到 caller 处. @Around 建议在被建议执行的方法上反复, 我们可以控制其输入
		 * 和输出还有执行的行为
		 */
		System.out.println("EmployeeAroundAspect: 在执行 getName() 方法之前");
		
		Object value = null;
		try {
			/* 在 getName() 方法上执行 @Around 建议 */
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("EmployeeAroundAspect: getName() 方法执行完毕且返回的值为: " + value);
		
		return value;
	}
}
