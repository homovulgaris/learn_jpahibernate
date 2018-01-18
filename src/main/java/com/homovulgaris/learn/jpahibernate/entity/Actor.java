package com.homovulgaris.learn.jpahibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Actor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	private String name;
	
	@ManyToMany(mappedBy="actors")
	private Set<Movie> movies = new HashSet<Movie>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	public Actor(String name, Set<Movie> movies) {
		super();
		this.name = name;
		this.movies = movies;
	}

	public Actor(String name) {
		super();
		this.name = name;
	}

	public Actor() {
		super();
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", movies=" + movies.size() + "]";
	}
	
	
	
	
	
}
