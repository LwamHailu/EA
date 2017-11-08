package com.edu;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("appServlet-servlet.xml");
	   HelloWorld helloworld=(HelloWorld)context.getBean("greetingService");
	   helloworld.sayHello();
	  
	}

}
