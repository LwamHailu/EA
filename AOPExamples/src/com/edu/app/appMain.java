package com.edu.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.service.ShapeService;

public class appMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		    ShapeService shape= context.getBean("shapeService",ShapeService.class);
		    System.out.println(shape.getCircle().getName());
		    System.out.println(shape.getTriangle().getName());
		   

	}

}
