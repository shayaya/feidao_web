package com.feidao.web.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.feidao.web.backend.dao.EmployeeDao;
import com.feidao.web.backend.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional("transactionManager")
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}
	
	@Override
	@Transactional("transactionManager")
	public List<Employee> getEmployeeByFirstName(String firstName) {
		
		return employeeDao.getEmployeeByFirstName(firstName);
	}
	
}
