package com.homovulgaris.learn.jpahibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author P3502822
 *
 */
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "enrolment_id", nullable = false)
	private String enrolmentId;

	private String name;

	/*
	 * multiple students can have a common guide
	 * 
	 */
	/*
	 * cascade - will persist also a guide object without need of using separate
	 * save method (instead of use .persist) this approach is called Transitive
	 * persistence
	 */
	/*
	 * remove - will remove also an associated object from database (Guide will be
	 * deleted)
	 */
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "guide_id")
	private Guide guide;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnrolmentId() {
		return enrolmentId;
	}

	public void setEnrolmentId(String enrolmentId) {
		this.enrolmentId = enrolmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public Student(String enrolmentId, String name, Guide guide) {
		super();
		this.enrolmentId = enrolmentId;
		this.name = name;
		this.guide = guide;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", enrolmentId=" + enrolmentId + ", name=" + name + ", guide=" + guide + "]";
	}

}
