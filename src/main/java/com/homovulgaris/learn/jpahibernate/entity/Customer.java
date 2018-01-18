package com.homovulgaris.learn.jpahibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@OneToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="passport_id", unique=true)
	private Passport passport;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public Customer(String name, Passport passport) {
		super();
		this.name = name;
		this.passport = passport;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", passport=" + passport + "]";
	}
	
	
	
	
}
