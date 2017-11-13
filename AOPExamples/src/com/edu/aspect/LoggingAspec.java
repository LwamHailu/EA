package com.edu.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspec {

	@Before("getAllMethods() && allTriangleMethods()")
	public void loggingAspect() {
		System.out.println("Advice is running !");
	}

	@Before("getAllMethods()")
	public void secondAdvice() {
		System.out.println("second advice is running");

	}

	@Pointcut("execution(* get*(..))") // wildcard * .. argument or no argument
	public void getAllMethods() {
	}

	@Pointcut("within(com.edu.model.Triangle)") // within takes class where as
												// execution takes method
	public void allTriangleMethods() {
	}

}
