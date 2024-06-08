package com.bootcamp.demo_restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoRestfulApplication {

	public static void main(String[] args) {
		// Try to find a bean can be @autowird to CommandLineRunner (Interface)
		// bean.run(); -> one of the processes of SpringApplication.run()
		SpringApplication.run(DemoRestfulApplication.class, args);
	}

}
