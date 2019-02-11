package com.honglin_chen.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.honglin_chen.spring.service.EmployeeService;

public class SpringMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); 
		EmployeeService service = context.getBean("employeeService", EmployeeService.class); 
	
		/* 通过员工服务将已经设置好的员工名字输出 */ 
		
		/* 当 call 服务类的任何一个 get 方法时, getAllAdvice @Before 建议将会被执行 */
		
		/* 当 call 服务类的任何一个方法之前, 根据设定的 Pointcut 表达式 allMethodsPointcut()
		 * 我们有 @Before 建议 allServiceMethodsAdvice() 满足表达式并且会执行 @Before 建议
		 */
		
		/* 在执行 getName() 方法之前我们通过XML文件设置 @Around 建议执行 */ 
		/* 当所有的定义的切面及其对应的建议被执行完毕后 */
		System.out.println("当前的员工是: " + service.getEmployee().getName()); 
		service.getEmployee().setName("Michael Chen"); 
		service.getEmployee().throwException(); 
	
		context.close(); 	
	}
}
