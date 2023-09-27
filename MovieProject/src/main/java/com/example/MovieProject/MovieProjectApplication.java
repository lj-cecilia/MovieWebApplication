package com.example.MovieProject;

import org.springframework.boot.SpringApplication;	//this SpringApplication contains a method named run
import org.springframework.boot.autoconfigure.SpringBootApplication;	//Spring Boot application annotations
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController    //let api know this class is not a regular java class but is a restcontroller
public class MovieProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieProjectApplication.class, args);
	}
//
//	//there will be a couple of layers, service layer, data access layer, and api layer
//	@GetMapping("/root")	//this is an api root, only used to map HTTP GET request
//	public String apiRoot() {
//		return "Hello World!";
//	}

}
