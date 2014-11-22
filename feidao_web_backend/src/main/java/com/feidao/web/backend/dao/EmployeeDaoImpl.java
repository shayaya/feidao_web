package com.feidao.web.backend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.feidao.web.backend.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(Employee employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		
		Query q = sessionFactory.getCurrentSession().createQuery("from Employee where upper(firstName)=upper(:firstName) order by firstName");
		q.setParameter("firstName", firstName);
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Employee getEmployeeByEmail(String email) {
		
		Query q = sessionFactory.getCurrentSession().createQuery("from Employee where upper(email)=upper(:email)");
		q.setParameter("email", email);
		List<Employee> empList = (List<Employee>)q.list();
		if(null == empList || empList.size() <=0){
			return null;
		}
		return empList.get(0);
	}
	
}
