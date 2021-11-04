package com.shiva.examples.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
	private String name;
	private Parrot parrot;
	
	@Autowired
	private Book book;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Parrot getParrot() {
		return parrot;
	}
	public void setParrot(Parrot parrot) {
		this.parrot = parrot;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
