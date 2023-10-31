package com.jbconnect.healthclinix.entity.user.adapter;

import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jbconnect.healthclinix.entity.user.dto.UserRequestDTO;
import com.jbconnect.healthclinix.entity.user.dto.UserResponseDTO;
import com.jbconnect.healthclinix.entity.user.mapper.UserMapper;
import com.jbconnect.healthclinix.entity.user.model.UserModel;
import com.jbconnect.healthclinix.entity.user.port.SavePort;
import com.jbconnect.healthclinix.entity.user.repository.UserModelRepository;

@Component
public class SaveSpringDataAdapter implements SavePort<UserRequestDTO, UserResponseDTO> {

    private final UserMapper userMapper;

    private final UserModelRepository userModelRepositoryr;

    public SaveSpringDataAdapter(UserMapper userMapper, UserModelRepository userModelRepositoryr) {
        this.userMapper = userMapper;
        this.userModelRepositoryr = userModelRepositoryr;
    }

    @Override
    @Transactional(readOnly = false)
    public UserResponseDTO execute(UserRequestDTO userRequestDTO) {
        UserModel user = this.userMapper.userRequestToUserModel(userRequestDTO);
        //Cryptography user password
        user.setPasswordUser(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setCreateAt(LocalDateTime.now());

        //TODO - Verify why create a new ID with error when try to save
        try{
            this.userModelRepositoryr.save(user);
            return this.userMapper.userModelToUserResponseDTO(user);
        }catch(Exception exception){
            throw new RuntimeException("Error trying save a new User {} " + exception.getMessage());
        }
    }
}
