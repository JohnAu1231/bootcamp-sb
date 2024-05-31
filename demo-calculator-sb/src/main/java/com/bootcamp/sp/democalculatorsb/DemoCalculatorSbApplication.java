package com.bootcamp.sp.democalculatorsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan: 
// Before Application starts, 
// 1. scan all java class (under folder on or below the class annotated@SpringBootApplication)
// annotated with @Controller,@ Service, @Repository, @Configuration
// 2. For example, CalculatorController.java (@Controller). 
// Then spring will create an object for CalculatorController.class, and put it into the spring context.
// 3. When there is a client call the API defined in CalculatorController.class, spring will ping the object
// from spring context and then call the instance method
public class DemoCalculatorSbApplication {

 private static ApplicationContext context;

	public static ApplicationContext getContext(){
		return DemoCalculatorSbApplication.context;
	}
	public static void main(String[] args) {
		DemoCalculatorSbApplication.context = SpringApplication.run(DemoCalculatorSbApplication.class, args);

		//Definition of Ban in Java:
		// - Similar to java object.
		// - But bean cannot be explicity created by the object behavior
		// - Spring itself will perform component scan, and then create the bean (java object) into spring context
		// - You can just annotate @Controller, @Service, @Repository, @Configuration to indicate the above behavior
		// String[] beans = DemoCalculatorSbApplication.context.getBeanDefinitionNames();

		// System.out.println(Arrays.toString(beans));
		
		



	}

}
