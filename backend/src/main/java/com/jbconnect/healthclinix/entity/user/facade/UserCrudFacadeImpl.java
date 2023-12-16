package com.jbconnect.healthclinix.entity.user.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.jbconnect.healthclinix.entity.user.dto.UserRequestDTO;
import com.jbconnect.healthclinix.entity.user.dto.UserResponseDTO;
import com.jbconnect.healthclinix.entity.user.port.FindOnePort;
import com.jbconnect.healthclinix.entity.user.port.GetByFiltersPort;
import com.jbconnect.healthclinix.entity.user.port.SavePort;

@Component
public class UserCrudFacadeImpl implements UserCrudFacade {

	private final SavePort<UserRequestDTO, UserResponseDTO> savePort;

	private final GetByFiltersPort<Pageable, UserRequestDTO, UserResponseDTO> getByFiltersPort;
	
	private final FindOnePort<Long, UserResponseDTO> findOnePort;

	public UserCrudFacadeImpl(SavePort<UserRequestDTO, UserResponseDTO> savePort,
			GetByFiltersPort<Pageable, UserRequestDTO, UserResponseDTO> getByFiltersPort,
			FindOnePort<Long, UserResponseDTO> findOnePort) {
		this.savePort = savePort;
		this.getByFiltersPort = getByFiltersPort;
		this.findOnePort = findOnePort;

	}

	@Override
	public UserResponseDTO save(UserRequestDTO userRequestDTO) {
		return this.savePort.execute(userRequestDTO);
	}

	@Override
	public Page<UserResponseDTO> getByFilters(Pageable pageable, UserRequestDTO userRequestDTO) {
		return this.getByFiltersPort.execute(pageable, userRequestDTO);
	}

	@Override
	public UserResponseDTO findOne(Long id) {
		return this.findOnePort.execute(id);
	}

}
