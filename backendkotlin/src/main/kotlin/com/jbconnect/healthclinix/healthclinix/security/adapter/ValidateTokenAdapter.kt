package com.jbconnect.healthclinix.healthclinix.security.adapter

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.jbconnect.healthclinix.healthclinix.security.port.ValidateTokenPort
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ValidateTokenAdapter : ValidateTokenPort<String, String> {
    @Value("\${api.security.token.secret}")
    private val secret: String? = null

    override fun execute(token: String): String {
        return try {
            val algorithm: Algorithm = Algorithm.HMAC256(secret)
            JWT.require(algorithm)
                .withIssuer("heath-clinic-api")
                .build()
                .verify(token)
                .subject
        } catch (jwtVerificationException: JWTVerificationException) {
            ""
        }
    }

}