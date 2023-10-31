package com.jbconnect.healthclinix.entity.user.adapter;

import com.jbconnect.healthclinix.entity.user.dto.UserRequestDTO;
import com.jbconnect.healthclinix.entity.user.dto.UserResponseDTO;
import com.jbconnect.healthclinix.entity.user.mapper.UserMapper;
import com.jbconnect.healthclinix.entity.user.model.UserModel;
import com.jbconnect.healthclinix.entity.user.port.GetByFiltersPort;
import com.jbconnect.healthclinix.entity.user.repository.UserModelRepository;
import com.jbconnect.healthclinix.entity.user.repository.UserModelSpecification;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Pageable;

@Component
public class GetByFiltersAdapter implements GetByFiltersPort<Pageable, UserRequestDTO, UserResponseDTO> {

    private final UserMapper userMapper;

    private final UserModelRepository userModelRepository;

    public GetByFiltersAdapter(UserMapper userMapper, UserModelRepository userModelRepository) {
        this.userMapper = userMapper;
        this.userModelRepository = userModelRepository;
    }

    @Override
    public Page<UserResponseDTO> execute(Pageable pageable, UserRequestDTO userRequestDTO) {
        UserModel userModelMap = this.userMapper.userRequestToUserModel(userRequestDTO);

        return this.userModelRepository.findAll(UserModelSpecification.getByFilters(userModelMap), pageable)
                .map(this.userMapper::userModelToUserResponseDTO);
    }
}
