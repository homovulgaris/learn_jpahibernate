package com.homovulgaris.learn.jpahibernate.domain;

import java.util.List;

public class Book {
	private String isbn;
	private String name;
	private Publisher publisher;
	private List<Chapter> chapters;

	public String getIsbn() {
		return isbn;
	}

	public String getName() {
		return name;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	private void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	private void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	
	
	public Book() {
		super();
	}

	public Book(String isbn, String name, Publisher publisher, List<Chapter> chapters) {
		super();
		this.setIsbn(isbn);
		this.setName(name);
		this.setChapters(chapters);
		this.setPublisher(publisher);
	}

}
