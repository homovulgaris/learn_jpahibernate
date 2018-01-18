package com.homovulgaris.learn.jpahibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	/*
	 * This will create an join table, which will have columns movie id fulfilled
	 * with ID of movie and actor_id fulfilled with ID of actor
	 */
	/*
	 * THis entity is responsible for changes of actors, because is an owner of
	 * relationship between actors
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "movie_actor", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
			@JoinColumn(name = "actor_id") })
	private Set<Actor> actors = new HashSet<Actor>();

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

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public Movie(String name, Set<Actor> actors) {
		super();
		this.name = name;
		this.actors = actors;
	}

	public Movie() {
		super();
	}

	public Movie(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", actors=" + actors.size() + "]";
	}

	
}
