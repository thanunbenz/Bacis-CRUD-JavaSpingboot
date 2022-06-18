package com.springbootnewbie.newbie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NewbieApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewbieApplication.class, args);
	}

	@GetMapping("/say")
	String sat() {
		return "hehehe123";
	}
}
