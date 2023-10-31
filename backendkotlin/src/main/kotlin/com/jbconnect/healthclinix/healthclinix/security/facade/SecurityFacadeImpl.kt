package com.jbconnect.healthclinix.healthclinix.security.facade

import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserRequestDTO
import com.jbconnect.healthclinix.healthclinix.security.port.LoginPort
import org.springframework.stereotype.Component


@Component
class SecurityFacadeImpl(val loginPort : LoginPort<UserRequestDTO, String>) : SecurityFacade {
    override fun login(userRequestDTO: UserRequestDTO): String {
        return this.loginPort.execute(userRequestDTO)
    }

}