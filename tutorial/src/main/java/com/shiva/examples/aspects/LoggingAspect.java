package com.shiva.examples.aspects;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.shiva.examples.model.CommentService;

@Component
@Aspect
public class LoggingAspect {
	Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	
	@Around("execution(* com.shiva.examples.*.CommentService.process*(..))")
	public String log(ProceedingJoinPoint jp) throws Throwable {
		// logger.info(jp.toString() + " called");
		logger.info(jp.getSignature().getName() + "(" + Arrays.asList(jp.getArgs()) + ")");
		String arg = (String) jp.getArgs()[0];
		Object []newArgs = new String[] {arg.toUpperCase()};
		return (String) jp.proceed(newArgs);
	}
}
