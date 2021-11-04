package com.shiva.examples.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {
	@Autowired
	CommentRepository repo;
	
	public String process(String s) {
		System.out.println("Comment Processor " + this.hashCode() + ": Repo " + repo.hashCode());
		repo.storeComment(s);
		return s;
	}
}
