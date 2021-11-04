package com.shiva.examples.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Machine {
	private String name;

	private Battery battery;
	
	//@Autowired
	public Machine(Battery battery) {
		this.battery = battery;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Battery getBattery() {
		// TODO Auto-generated method stub
		return battery;
	}
}
