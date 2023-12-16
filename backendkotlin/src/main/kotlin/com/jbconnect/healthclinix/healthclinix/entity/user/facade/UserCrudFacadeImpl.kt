package com.jbconnect.healthclinix.healthclinix.entity.user.facade

import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserRequestDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserResponseDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.port.FindOnePort
import com.jbconnect.healthclinix.healthclinix.entity.user.port.GetByFiltersPort
import com.jbconnect.healthclinix.healthclinix.entity.user.port.SavePort
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component


@Component
class UserCrudFacadeImpl(
    val savePort: SavePort<UserRequestDTO, UserResponseDTO>,
    val getByFiltersPort: GetByFiltersPort<Pageable, UserRequestDTO, UserResponseDTO>,
    val findOnePort: FindOnePort<Long, UserResponseDTO>
) : UserCrudFacade {
    override fun save(userRequestDTO: UserRequestDTO): UserResponseDTO = savePort.execute(userRequestDTO)

    override fun findOne(id: Long): UserResponseDTO = findOnePort.execute(id)

    override fun getByFilters(pageable: Pageable, userRequestDTO: UserRequestDTO): Page<UserResponseDTO> = getByFiltersPort.execute(pageable, userRequestDTO)

}