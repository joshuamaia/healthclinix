package com.jbconnect.healthclinix.healthclinix.entity.user.adapter

import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserRequestDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserResponseDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.mapper.UserMapper
import com.jbconnect.healthclinix.healthclinix.entity.user.model.UserModel
import com.jbconnect.healthclinix.healthclinix.entity.user.port.SavePort
import com.jbconnect.healthclinix.healthclinix.entity.user.repository.UserModelRepository

import org.springframework.stereotype.Component

@Component
class SaveSpringDataAdapter(private val repository: UserModelRepository, private val mapper: UserMapper) : SavePort<UserRequestDTO, UserResponseDTO> {
    override fun execute(userModel: UserRequestDTO) : UserResponseDTO {
        val entity: UserModel = mapper.userRequestToUserModel(userModel)
        return mapper.userModelToUserResponseDTO(repository.save(entity))
    }
}