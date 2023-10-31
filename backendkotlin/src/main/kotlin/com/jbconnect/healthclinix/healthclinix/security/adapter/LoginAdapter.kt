package com.jbconnect.healthclinix.healthclinix.security.adapter

import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserRequestDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.mapper.UserMapper
import com.jbconnect.healthclinix.healthclinix.entity.user.model.UserModel
import com.jbconnect.healthclinix.healthclinix.security.port.GenerateTokenPort
import com.jbconnect.healthclinix.healthclinix.security.port.LoginPort
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component


@Component
class LoginAdapter(
    val userMapper: UserMapper,
    val generateTokenPort : GenerateTokenPort<UserRequestDTO, String>,
    val authenticationManager: AuthenticationManager
) : LoginPort<UserRequestDTO, String> {

    override fun execute(userRequestDTO: UserRequestDTO): String {
        return try {
            val usernamePasswordAuthenticationToken =
                UsernamePasswordAuthenticationToken(userRequestDTO.userName, userRequestDTO.passwordUser)
            val authentication: Authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken)
            val userModelAutentication = authentication.principal as UserModel
            val userRequestDTOAuth = userMapper.userModelToUserRequestDTO(userModelAutentication)
            userRequestDTOAuth.userName = userModelAutentication.username
            generateTokenPort.execute(userRequestDTOAuth)
        } catch (e: Exception) {
            throw RuntimeException("Error in login {} $e")
        }
    }

}