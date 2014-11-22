package com.feidao.web.rest.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.feidao.web.backend.model.Employee;
import com.feidao.web.backend.model.EmployeeList;
import com.feidao.web.backend.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value ="/{email:.+}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8", "application/xml; charset=utf-8"})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Employee getEmployeeByEmail(@PathVariable(value="email") String email){
		
		return employeeService.getEmployeeByEmail(email);
	}
	
	@RequestMapping(value ="/name/{firstName}", method = RequestMethod.GET, produces = {"application/json; charset=utf-8", "application/xml; charset=utf-8"})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public EmployeeList getEmployeeByFirstName(@PathVariable(value="firstName") String firstName){
		
		List<Employee> employees = employeeService.getEmployeeByFirstName(firstName);
		EmployeeList employeeList = new EmployeeList();
		employeeList.setEmployees(employees);
		return employeeList;
	}
}
