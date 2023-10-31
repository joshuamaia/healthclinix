package com.jbconnect.healthclinix.healthclinix.entity.user.adapter

import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserRequestDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserResponseDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.mapper.UserMapper
import com.jbconnect.healthclinix.healthclinix.entity.user.model.UserModel
import com.jbconnect.healthclinix.healthclinix.entity.user.port.GetByFiltersPort
import com.jbconnect.healthclinix.healthclinix.entity.user.repository.UserModelRepository
import com.jbconnect.healthclinix.healthclinix.entity.user.repository.UserModelSpecification
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class GetByFiltersAdapter(private val repository: UserModelRepository, private val mapper: UserMapper) :
    GetByFiltersPort<Pageable, UserRequestDTO, UserResponseDTO> {

    override fun execute(pageable: Pageable, userRequestDTO: UserRequestDTO): Page<UserResponseDTO> {
        val userModelMap: UserModel = this.mapper.userRequestToUserModel(userRequestDTO)
        return this.repository.findAll(UserModelSpecification.getByFilters(userModelMap), pageable)
            .map(this.mapper::userModelToUserResponseDTO)
    }

}