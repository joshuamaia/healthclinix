package com.jbconnect.healthclinix.entity.user.adapter;

import org.springframework.stereotype.Component;

import com.jbconnect.healthclinix.entity.user.dto.UserResponseDTO;
import com.jbconnect.healthclinix.entity.user.mapper.UserMapper;
import com.jbconnect.healthclinix.entity.user.port.FindOnePort;
import com.jbconnect.healthclinix.entity.user.repository.UserModelRepository;

@Component
public class FindOneSpringDataAdapter implements FindOnePort<Long, UserResponseDTO> {

	private final UserMapper userMapper;

	private final UserModelRepository userModelRepositoryr;

	public FindOneSpringDataAdapter(UserMapper userMapper, UserModelRepository userModelRepositoryr) {
		this.userMapper = userMapper;
		this.userModelRepositoryr = userModelRepositoryr;
	}

	@Override
	public UserResponseDTO execute(Long in) {
		return userMapper.userModelToUserResponseDTO(userModelRepositoryr.findById(in).orElseThrow());
	}

}
