package com.jbconnect.healthclinix.security.facade;

import org.springframework.stereotype.Component;

import com.jbconnect.healthclinix.entity.user.dto.UserRequestDTO;
import com.jbconnect.healthclinix.security.port.LoginPort;

@Component
public class SecurityFacadeImpl implements SecurityFacade {

	private final LoginPort<UserRequestDTO, String> loginPort;

	public SecurityFacadeImpl(LoginPort<UserRequestDTO, String> loginPort) {
		this.loginPort = loginPort;
	}

	@Override
	public String login(UserRequestDTO userRequestDTO) {
		return this.loginPort.execute(userRequestDTO);
	}

}
