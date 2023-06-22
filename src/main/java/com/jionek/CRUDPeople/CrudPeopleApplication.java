package com.jionek.CRUDPeople;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CrudPeopleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudPeopleApplication.class, args);
	}

	@GetMapping("/")
	public String hello(){
		return "Hello Here as well";
	}
}
