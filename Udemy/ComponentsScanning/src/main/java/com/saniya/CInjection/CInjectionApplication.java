package com.saniya.CInjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.saniya.CInjection",
				"com.luv2code",
				"com.utils"}
)
public class CInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CInjectionApplication.class, args);
	}

}
