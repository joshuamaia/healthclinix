package com.jbconnect.healthclinix.healthclinix.entity.user.adapter

import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserResponseDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.mapper.UserMapper
import com.jbconnect.healthclinix.healthclinix.entity.user.port.FindOnePort
import com.jbconnect.healthclinix.healthclinix.entity.user.repository.UserModelRepository
import org.springframework.stereotype.Component

@Component
class FindOneSpringDataAdapter(val userMapper: UserMapper, val userModelRepository: UserModelRepository) : FindOnePort<Long, UserResponseDTO> {
    override fun execute(i: Long): UserResponseDTO {
        return this.userMapper.userModelToUserResponseDTO(this.userModelRepository.findById(i).orElseThrow())
    }
}