package com.jbconnect.healthclinix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Health Clinix API", version = "1.0", description = "Health Clinix API Information"))
public class HealthclinixApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthclinixApplication.class, args);
	}

}
