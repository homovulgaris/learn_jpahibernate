package com.homovulgaris.learn.jpahibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Embedded
	private Adress adress;

	public Long getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Person(String name, Adress adress) {
		super();
		this.name = name;
		this.adress = adress;
	}

	public Person() {
		super();
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", adress=" + adress + "]";
	}
	
	
	
	
	
	

}
