package com.honglin_chen.spring.aspect;

import org.aspectj.lang.annotation.Aspect; 
import org.aspectj.lang.annotation.Before; 

/* 标记(注解)当前类为一个切面 */ 
@Aspect
public class EmployeeAspect {
	/* 注解当前方法为 @Before 建议 */
	/* 在执行 Employee 类中的 getName() 方法之前先执行 getNameAdvice() 建议 */
	@Before("execution(public String getName())")
	public void getNameAdvice() {
		/* 对任意署名为 getName() 的 Spring Bean 方法, 该建议将会被执行 */
		/* 即当我们使用 new 关键字创建员工实例时该建议不会执行, 只有通过应用
		 * 文本取得到这个 bean 的时候该建议将会被执行 
		 */
		System.out.println("EmployeeAspect: 在getName()方法上执行建议");
	}
	
	/* @Before 建议的参数为 Pointcut 表达式 */ 
	@Before("execution(* com.honglin_chen.spring.service.*.get*())")
	public void getAllAdvice() {
		/* 该建议将会应用于所有 Service 包中的方法名以 get 起始且不带任何参数的类中 */  
		System.out.println("EmployeeAspect: 服务类方法 getter called"); 
	}
}
