package com.jbconnect.healthclinix.entity.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jbconnect.healthclinix.entity.user.dto.UserRequestDTO;
import com.jbconnect.healthclinix.entity.user.dto.UserResponseDTO;
import com.jbconnect.healthclinix.entity.user.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(source = "username", target = "userName")
    UserResponseDTO userModelToUserResponseDTO(UserModel userModel);

    UserModel userRequestToUserModel(UserRequestDTO userRequestDTO);

    @Mapping(source = "username", target = "userName")
    List<UserResponseDTO> userModelListToUserResponseDTOList(List<UserModel> userModelList);

    UserRequestDTO userModelToUserRequestDTO(UserModel userModel);
}
