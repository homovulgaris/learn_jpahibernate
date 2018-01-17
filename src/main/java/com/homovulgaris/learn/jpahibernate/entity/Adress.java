package com.homovulgaris.learn.jpahibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author P3502822
 *
 */
@Embeddable
public class Adress {

	@Column(name="adress_street")
	private String street;
	
	@Column(name="adress_city")
	private String city;
	
	@Column(name="adress_zipcode")
	private String zipcode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Adress(String street, String city, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

	public Adress() {
		super();
	}

	@Override
	public String toString() {
		return "Adress [street=" + street + ", city=" + city + ", zipcode=" + zipcode + "]";
	}
	
	
	
	
}
