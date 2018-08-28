package com.springBoot.ExceptionSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springBoot.ExceptionSpringBoot.dao.EmployeeDao;
import com.springBoot.ExceptionSpringBoot.pojo.Employee;

@Component
public class ServiceImpl implements EmployeeService{
 @Autowired
	EmployeeDao dao;
	public void addEmployee(Employee employee)
	{
		dao.save(employee);
	}
	
	public List<Employee> viewAllEmployee()
	{
		return dao.findAll();
	}
	
	public void updateEmployee(Employee employee) {
	
		dao.save(employee);
	}
	
	public void deleteEmployee(int id)
	{
		dao.deleteById(id);
	}
}
