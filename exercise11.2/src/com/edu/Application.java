package com.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new
				 ClassPathXmlApplicationContext("springconfig.xml");
		IProductService productService =context.getBean("productService", IProductService.class);
		System.out.println("we have " + productService.getNumberInStock(423) + " product(s) with productNumber 423 in stock");
		System.out.println("we have " + productService.getNumberInStock(239)+ " product(s) with productNumber 239 in stock"); 

	}

}
