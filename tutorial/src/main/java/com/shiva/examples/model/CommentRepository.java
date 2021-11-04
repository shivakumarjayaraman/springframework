package com.shiva.examples.model;

import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {
	public void storeComment(String s) {
		System.out.println("Persisting comment " + s);
	}
}
