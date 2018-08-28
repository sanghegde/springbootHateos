package com.springBoot.ExceptionSpringBoot.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.ExceptionSpringBoot.pojo.Employee;
import com.springBoot.ExceptionSpringBoot.service.ServiceImpl;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;



@RestController
public class EmployeeController {
	@Autowired
	private ServiceImpl service;

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST, consumes = "application/json")
	public void addEmployee(@RequestBody Employee employee) {
		service.addEmployee(employee);

	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	public Collection<Employee> viewAllEmployee() {
		return service.viewAllEmployee();
	}

	@RequestMapping(value = "/employee/update", method = RequestMethod.PUT, consumes = "application/json")
	public void updateEmployee(@RequestBody Employee employee) {
		service.updateEmployee(employee);
	}
	@RequestMapping(value = "/employee/delete", method = RequestMethod.DELETE)
	public void deleteEmployee(int id)
	{
		service.deleteEmployee(id);
	}
	@RequestMapping(value = "/employee/{start}/{count}", method = RequestMethod.GET)
	public Resources getEmployeeByPages(@PathVariable int start,@PathVariable int count)
	{
		List<Employee> tempemployee=service.viewAllEmployee();
		List<Employee> employee=new ArrayList<>();
		
		for(int i=start;i<=start+count;i++)
		{
			employee.add(tempemployee.get(i));
		}
		
		Link nextLink=linkTo(methodOn(this.getClass()).getEmployeeByPages(start+count, count)).withRel("next link");
		Link previousLink=linkTo(methodOn(this.getClass()).getEmployeeByPages(start-count>=0?start-count:1, count)).withRel("previouslink");
		return new Resources<>(employee,nextLink,previousLink);
	}
}
