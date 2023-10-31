package com.jbconnect.healthclinix.healthclinix.entity.user.facade

import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserRequestDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserResponseDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface UserCrudFacade {
    fun save(userRequestDTO: UserRequestDTO) : UserResponseDTO

    fun getByFilters(pageable: Pageable, userRequestDTO: UserRequestDTO): Page<UserResponseDTO>
}