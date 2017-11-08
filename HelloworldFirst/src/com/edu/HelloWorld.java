package com.edu;

public class HelloWorld {
	private String greetings;
     public HelloWorld(){}
     public HelloWorld(String greetings){
    	 this.greetings=greetings;
     }
	
	public String getGreetings() {
		return greetings;
	}

	
      public void  sayHello(){
    	  System.out.println(greetings);
      }
	
      public void setGreetings(String greetings) {
  		this.greetings = greetings;
  	}

}
