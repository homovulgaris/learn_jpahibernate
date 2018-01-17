package com.homovulgaris.learn.jpahibernate.domain;

public class Publisher {
	private String code;
	private String name;

	public Publisher() {

	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	private void setCode(String code) {
		this.code = code;
	}

	private void setName(String name) {
		this.name = name;
	}

	public Publisher(String code, String name) {
		super();
		setCode(code);
		setName(name);
	}

}
