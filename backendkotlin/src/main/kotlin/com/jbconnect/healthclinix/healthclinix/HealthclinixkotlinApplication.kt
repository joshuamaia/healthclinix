package com.jbconnect.healthclinix.healthclinix

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(info = Info(title = "Health Clinix API", version = "1.0", description = "Health Clinix API Information"))
class HealthclinixkotlinApplication

fun main(args: Array<String>) {
	runApplication<HealthclinixkotlinApplication>(*args)
}
