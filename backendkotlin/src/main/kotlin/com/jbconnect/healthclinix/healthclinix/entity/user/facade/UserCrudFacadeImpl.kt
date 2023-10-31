package com.jbconnect.healthclinix.healthclinix.entity.user.facade

import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserRequestDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserResponseDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.port.GetByFiltersPort
import com.jbconnect.healthclinix.healthclinix.entity.user.port.SavePort
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component


@Component
class UserCrudFacadeImpl(
    val savePort: SavePort<UserRequestDTO, UserResponseDTO>,
    val getByFiltersPort: GetByFiltersPort<Pageable, UserRequestDTO, UserResponseDTO>
) : UserCrudFacade {
    override fun save(userRequestDTO: UserRequestDTO): UserResponseDTO {
        return savePort.execute(userRequestDTO)
    }

    override fun getByFilters(pageable: Pageable, userRequestDTO: UserRequestDTO): Page<UserResponseDTO> {
        return getByFiltersPort.execute(pageable, userRequestDTO)
    }

}