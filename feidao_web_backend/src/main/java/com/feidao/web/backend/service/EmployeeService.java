package com.feidao.web.backend.service;

import java.util.List;

import com.feidao.web.backend.model.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);
	
	public List<Employee> getEmployeeByFirstName(String firstName);

	public Employee getEmployeeByEmail(String email);

}
