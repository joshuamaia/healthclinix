package com.jbconnect.healthclinix.security.facade;

import com.jbconnect.healthclinix.entity.user.dto.UserRequestDTO;

public interface SecurityFacade {

	String login(UserRequestDTO userRequestDTO);

}
