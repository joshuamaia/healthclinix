package com.jbconnect.healthclinix.healthclinix.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@Configuration
class CorConfiguration {

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource? {
        val configuration = CorsConfiguration()
        configuration.addAllowedOrigin("*") // Permitir todas as origens
        configuration.addAllowedMethod("*") // Permitir todos os métodos HTTP (GET, POST, PUT, DELETE, etc.)
        configuration.addAllowedHeader("*") // Permitir todos os cabeçalhos
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration) // Aplicar a configuração CORS a todas as URLs
        return source
    }
}