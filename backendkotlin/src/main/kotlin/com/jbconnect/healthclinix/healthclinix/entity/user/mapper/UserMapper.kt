package com.jbconnect.healthclinix.healthclinix.entity.user.mapper

import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserRequestDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserResponseDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.model.UserModel
import org.mapstruct.Mapper
import org.mapstruct.Mapping


@Mapper(componentModel = "spring")
interface UserMapper {
    @Mapping(source = "username", target = "userName")
    fun userModelToUserResponseDTO(userModel: UserModel): UserResponseDTO

    fun userRequestToUserModel(userRequestDTO: UserRequestDTO): UserModel

    @Mapping(source = "username", target = "userName")
    fun userModelListToUserResponseDTOList(userModelList: List<UserModel?>): List<UserResponseDTO?>

    fun userModelToUserRequestDTO(userModel: UserModel): UserRequestDTO
}