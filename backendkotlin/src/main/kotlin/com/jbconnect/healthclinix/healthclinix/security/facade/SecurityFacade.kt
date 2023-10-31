package com.jbconnect.healthclinix.healthclinix.security.facade

import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserRequestDTO


fun interface SecurityFacade {

    fun login(userRequestDTO: UserRequestDTO): String
}