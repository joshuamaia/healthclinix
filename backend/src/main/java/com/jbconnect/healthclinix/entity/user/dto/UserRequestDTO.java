package com.jbconnect.healthclinix.entity.user.dto;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRequestDTO {
    private Long id;
    private String userName;
    private String passwordUser;
    private String email;
    //TODO - Create UserRequestDTO only for create a new User
    private List<RoleDTO> roles;
}
