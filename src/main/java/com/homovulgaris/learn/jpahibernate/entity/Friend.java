package com.homovulgaris.learn.jpahibernate.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;

	/*
	 * Creates collection table which means, that there will be a table, which will
	 * have a nickname value and id of friend associated with it
	 */
	@ElementCollection
	@CollectionTable(name = "friend_adress", /* this will join id of friend table into table friend_nickname */joinColumns = @JoinColumn(name = "friend_id"))
	//"friend_id" is a composite primary key
	@Column(name = "adress")
	private Collection<Adress> adresses = new ArrayList<Adress>();

	public Friend(String name, String email, Collection<Adress> nicknames) {
		super();
		this.name = name;
		this.email = email;
		this.adresses = nicknames;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(Collection<Adress> nicknames) {
		this.adresses = nicknames;
	}

	public Friend() {
		super();
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", email=" + email + ", nicknames=" + adresses + "]";
	}
	
	

}
