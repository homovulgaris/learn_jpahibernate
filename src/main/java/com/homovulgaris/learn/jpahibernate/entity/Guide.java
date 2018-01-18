package com.homovulgaris.learn.jpahibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author P3502822
 *
 */
@Entity
public class Guide {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "staff_id", nullable = false)
	private String staffId;

	@OneToMany(mappedBy = "guide", cascade= {CascadeType.PERSIST})
	private Set<Student> students = new HashSet<Student>();

	private Long salary;
	private String name;

	public Long getId() {
		return id;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Guide(String staffId, Long salary, String name) {
		super();
		this.staffId = staffId;
		this.salary = salary;
		this.name = name;
	}

	public Guide() {
		super();
	}
	
	/*
	 * This method is making Guide responsible for relationship which means, that connection between student and guide will be updated
	 */
	public void addStudent(Student student) {
		students.add(student);
		student.setGuide(this);
	}

	@Override
	public String toString() {
		return "Guide [id=" + id + ", staffId=" + staffId + ", students=" + students + ", salary=" + salary + ", name="
				+ name + "]";
	}
	
	

}
