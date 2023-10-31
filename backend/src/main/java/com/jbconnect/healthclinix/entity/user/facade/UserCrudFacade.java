package com.jbconnect.healthclinix.entity.user.facade;

import com.jbconnect.healthclinix.entity.user.dto.UserRequestDTO;
import com.jbconnect.healthclinix.entity.user.dto.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserCrudFacade {

	UserResponseDTO save(UserRequestDTO userRequestDTO);

	Page<UserResponseDTO> getByFilters(Pageable pageable, UserRequestDTO userRequestDTO);

}
