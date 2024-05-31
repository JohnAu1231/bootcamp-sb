package com.bootcamp.sb.sbhelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbHelloworldApplication {

	public static void main(String[] args) {
		// Start App Server (never end)
		SpringApplication.run(SbHelloworldApplication.class, args);
	}

}
