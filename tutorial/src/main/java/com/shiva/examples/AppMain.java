package com.shiva.examples;

import java.util.function.Supplier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shiva.examples.aspects.ToTime;
import com.shiva.examples.conf.ProjectConfig;
import com.shiva.examples.model.Buffalo;
import com.shiva.examples.model.CommentService;
import com.shiva.examples.model.Machine;
import com.shiva.examples.model.Parrot;
import com.shiva.examples.model.Person;

public class AppMain {

    public static void main(String[] args) {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
    	
    	Parrot p = ctx.getBean("parrot1", Parrot.class);
    	System.out.println(p.getName() + p.hashCode());
    	
    	p = ctx.getBean("dude", Parrot.class);
    	System.out.println(p.getName() + p.hashCode());
    	
    	p = ctx.getBean(Parrot.class);
    	System.out.println(p.getName() + p.hashCode());
    	
    	Buffalo b = ctx.getBean(Buffalo.class);
    	System.out.println(b.getName() + b.hashCode());
        
    	// register a custom buffalo
    	Buffalo ins = new Buffalo();
    	ins.setName("my maadu");
    	System.out.println(ins.getName() + ins.hashCode());
    	ctx.registerBean("maadu", Buffalo.class, ()->ins);
    	b = ctx.getBean("maadu", Buffalo.class);
    	System.out.println(b.getName() + b.hashCode());
    	
    	Person person = ctx.getBean(Person.class);
    	System.out.println(person.getName() + ": " + 
    			person.getParrot().getName() + ":" + person.getParrot().hashCode());
    	
    	person = ctx.getBean("jon", Person.class);
    	System.out.println(person.getName() + ": " + 
    			person.getParrot().getName() + ":" + person.getParrot().hashCode());
    	
    	System.out.println(person.getBook());
    	
    	Machine m = ctx.getBean(Machine.class);
    	System.out.println("DIRECT CLASS ******" + m.getClass().getName());
    	System.out.println(m.getBattery());
    	
    	// Demo for prototype beans
    	CommentService s = ctx.getBean(CommentService.class);
    	System.out.println("PROXY CLASS ********" + s.getClass().getName());
    	CommentService s2 = ctx.getBean(CommentService.class);
    	
    	System.out.println(s.hashCode() + "==" + s2.hashCode());
    	System.out.println(s.processComment("Hi Dude"));
    	System.out.println(s2.processComment("Wassup"));
    	
    	System.out.println(s2.slowMethod());
    }
    
    

}
