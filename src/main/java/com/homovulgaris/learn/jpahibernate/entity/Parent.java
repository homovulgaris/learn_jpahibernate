package com.homovulgaris.learn.jpahibernate.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Parent {
	
	@EmbeddedId
	private ParentCompositeKey parentPrimaryKey;

	/**
	 * @return the parentPrimaryKey
	 */
	public ParentCompositeKey getParentPrimaryKey() {
		return parentPrimaryKey;
	}

	/**
	 * @param parentPrimaryKey the parentPrimaryKey to set
	 */
	public void setParentPrimaryKey(ParentCompositeKey parentPrimaryKey) {
		this.parentPrimaryKey = parentPrimaryKey;
	}

	public Parent(ParentCompositeKey parentPrimaryKey) {
		super();
		this.parentPrimaryKey = parentPrimaryKey;
	}

	public Parent() {
		super();
	}
	
	
	

}
