package com.feidao.web.backend.dao;

import java.util.List;

import com.feidao.web.backend.model.Employee;

public interface EmployeeDao {


	public List<Employee> getEmployeeByFirstName(String firstName);

	public void addEmployee(Employee employee);

	public Employee getEmployeeByEmail(String email);

}
