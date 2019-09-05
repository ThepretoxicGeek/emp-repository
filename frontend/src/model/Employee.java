package model;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

import entities.EmployeeEntity;


@ManagedBean(value = "employee")
@SessionScoped
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surName;
	private Date dateOfBirth;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public EmployeeEntity getEntity()
	{
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setDateOfBirth(dateOfBirth);
		employeeEntity.setName(name);
		employeeEntity.setSurName(surName);
		return employeeEntity;
	}
}
