package com.springBoot.ExceptionSpringBoot.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	private String contactNUmber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNUmber() {
		return contactNUmber;
	}

	public void setContactNUmber(String contactNUmber) {
		this.contactNUmber = contactNUmber;
	}

	public Employee(int id, String name, String contactNUmber) {
		super();
		this.id = id;
		this.name = name;
		this.contactNUmber = contactNUmber;
	}
	public Employee() {
		
	}

}
