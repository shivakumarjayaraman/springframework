package com.shiva.examples.model;

import org.springframework.stereotype.Component;

@Component
public class Book {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
