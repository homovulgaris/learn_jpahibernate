package com.homovulgaris.learn.jpahibernate.entity;

import javax.persistence.*;

import com.homovulgaris.learn.jpahibernate.enumerations.EmployeeStatus;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@Column(name = "employee_id")
	private String employeeId;

	@Enumerated(EnumType.STRING)
	@Column(name = "employee_status")
	private EmployeeStatus employeeStatus;

	public Employee(String name, String employeId, EmployeeStatus employeeStatus) {
		super();
		this.name = name;
		this.employeeId = employeId;
		this.employeeStatus = employeeStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeStatus getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Employee() {
		super();
	}

}
