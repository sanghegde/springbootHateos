package com.springBoot.ExceptionSpringBoot.service;

import java.util.List;

import com.springBoot.ExceptionSpringBoot.pojo.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);
	public List<Employee> viewAllEmployee();
	public void updateEmployee(Employee employee);
	public void deleteEmployee(int id);

}
