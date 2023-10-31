package com.jbconnect.healthclinix.healthclinix.security.adapter

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserRequestDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.mapper.UserMapper
import com.jbconnect.healthclinix.healthclinix.entity.user.model.UserModel
import com.jbconnect.healthclinix.healthclinix.security.port.GenerateTokenPort
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Component
class GenerateTokenAdapter(val userMapper: UserMapper) :  GenerateTokenPort<UserRequestDTO, String>{

    @Value("\${api.security.token.secret}")
    val secret: String? = null

    override fun execute(userRequestDTO: UserRequestDTO): String {

        val userModel: UserModel = userMapper.userRequestToUserModel(userRequestDTO)
        return try {
            val algorithm: Algorithm = Algorithm.HMAC256(secret)
            JWT.create()
                .withIssuer("heath-clinic-api")
                .withSubject(userModel.username)
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm)
        } catch (jwtCreationException: JWTCreationException) {
            //TODO - Class error with details
            throw RuntimeException("Error with jwt creation {} " + jwtCreationException.message)
        }
    }

    private fun generateExpirationDate(): Instant? {
        return LocalDateTime.now().plusHours(4).toInstant(ZoneOffset.of("-03:00"))
    }
}