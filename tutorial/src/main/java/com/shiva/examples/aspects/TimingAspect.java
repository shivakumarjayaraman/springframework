package com.shiva.examples.aspects;

import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimingAspect {
	Logger logger = Logger.getLogger(TimingAspect.class.getName());
	
	@Around("@annotation(ToTime)")
	public Object log(ProceedingJoinPoint jp) throws Throwable {
		long t1 = new Date().getTime();
		Object ret = jp.proceed();
		long t2 = new Date().getTime();
		
		logger.info(jp.toString() + " took " + (t2-t1) + " ms" );
		
		return ret;
	}
}
