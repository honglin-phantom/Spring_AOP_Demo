package com.honglin_chen.spring.model;

import com.honglin_chen.spring.aspect.Loggable; 

/* 员工 bean */ 
public class Employee {
	private String name; 
	
	/* 得到当前员工的名字 */
	public String getName() {
		return this.name; 
	}
	
	/* 自定义的 Pointcut 注解 */ 
	@Loggable
	public void setName(String name) {
		this.name = name; 
	}
	
	public void throwException() {
		/* 抛出运行时产生的错误 */
		throw new RuntimeException("程序运行 Exception"); 
	}
}
