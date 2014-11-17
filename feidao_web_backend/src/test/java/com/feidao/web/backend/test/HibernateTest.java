package com.feidao.web.backend.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.feidao.web.backend.model.Employee;
import com.feidao.web.backend.service.EmployeeService;

public class HibernateTest {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/root-context.xml");
		
		EmployeeService employeeService = (EmployeeService)context.getBean("employeeServiceImpl");
		
		employeeService.addEmployee(buildEmployee1());
		
		List<Employee> employeeList = employeeService.getEmployeeByFirstName("feidao");
		
		if(null != employeeList){
			System.out.println("size of employee list: "+ employeeList.size());
		}
	}
	
	private static Employee buildEmployee1(){
		Employee employee = new Employee();
		employee.setEmail("feidao@shayaya.com");
		employee.setFirstName("feidao");
		employee.setLastName("shayaya");
		employee.setTelephone("1111");
		employee.setCreated(new Date());
		return employee;
	}

}
