package com.honglin_chen.spring.service;

import com.honglin_chen.spring.model.Employee; 

/* 员工服务提供一个 access point 给员工 bean */ 
public class EmployeeService {
	private Employee employee;
	
	/* 通过员工服务创建一个员工实例实现IoC, 即不通过员工类自己创造实例而是委托给服务来创建实例 */ 
	public Employee getEmployee() {
		return this.employee; 
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee; 
	}
 }
