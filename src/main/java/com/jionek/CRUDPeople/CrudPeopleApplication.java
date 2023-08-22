package com.jionek.CRUDPeople;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@RestController
@SpringBootApplication
public class CrudPeopleApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(CrudPeopleApplication.class, args);
	}

//	@GetMapping("/")
//	public String hello(){
//		return "Hello Here as well";
//	}
}
