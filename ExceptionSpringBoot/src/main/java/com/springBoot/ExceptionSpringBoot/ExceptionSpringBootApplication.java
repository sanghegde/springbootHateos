package com.springBoot.ExceptionSpringBoot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springBoot.ExceptionSpringBoot.pojo.Employee;
import com.springBoot.ExceptionSpringBoot.service.ServiceImpl;


@SpringBootApplication
public class ExceptionSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionSpringBootApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadintialData( ServiceImpl service)
	{
		return (args)->{
			service.addEmployee(new Employee(123, "abc", "def"));
			service.addEmployee(new Employee(124, "abc", "def"));
			service.addEmployee(new Employee(125, "abc", "def"));
			service.addEmployee(new Employee(126, "abc", "def"));
		};
	}
}

