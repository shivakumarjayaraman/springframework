package com.shiva.examples.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;

import com.shiva.examples.model.Parrot;
import com.shiva.examples.model.Person;

@Configuration
@ComponentScan(basePackages = "com.shiva.examples")
@EnableAspectJAutoProxy
public class ProjectConfig {
	
	@Bean(name="parrot1")
	Parrot parrot1() {
		Parrot p = new Parrot();
		p.setName("Koko");
		return p;
	}
	
	@Bean(name="dude")
	Parrot parrot2() {
		Parrot p = new Parrot();
		p.setName("Miki");
		return p;
	}
	
	@Bean
	@Primary
	Parrot parrot3() {
		Parrot p = new Parrot();
		p.setName("Riki");
		return p;
	}
	
	@Bean
	@Primary
	Person person() {
		Person p =  new Person();
		p.setName("Ella");
		p.setParrot(parrot2());
		return p;
	}
	
	@Bean(name="jon")
	Person person2(@Qualifier("parrot1") Parrot par) {
		Person p = new Person();
		p.setName("Jon");
		p.setParrot(par);
		return p;
	}

}
