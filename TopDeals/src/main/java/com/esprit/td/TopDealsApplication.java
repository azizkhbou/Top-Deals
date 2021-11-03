package com.esprit.td;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
// bech tsaker el configuration de spring security 
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)

public class TopDealsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopDealsApplication.class, args);
	}

}
