package com.shiva.examples.model;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Buffalo {
	private String name;
	
	@PostConstruct
	public void init() {
		//new Exception().printStackTrace();
		if (this.name == null) this.name = "Moo";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
