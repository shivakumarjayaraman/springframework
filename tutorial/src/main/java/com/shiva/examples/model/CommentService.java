package com.shiva.examples.model;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.shiva.examples.aspects.ToTime;

@Service
public class CommentService {
	Logger logger = Logger.getLogger(CommentService.class.getName());
	
	@Autowired
	ApplicationContext ctx ;
	
	public String processComment(String s) {
		CommentProcessor cp = ctx.getBean(CommentProcessor.class);
		return cp.process(s);
	}
	
	@ToTime
    public String  slowMethod() {
    	System.out.println("In slow method");
    	try { Thread.sleep(300); } catch (Exception e) {}
    	System.out.println("Done slow method");
    	return "Done";
    }
}
