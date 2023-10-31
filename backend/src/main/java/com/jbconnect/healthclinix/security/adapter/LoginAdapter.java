package com.jbconnect.healthclinix.security.adapter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.jbconnect.healthclinix.entity.user.dto.UserRequestDTO;
import com.jbconnect.healthclinix.entity.user.mapper.UserMapper;
import com.jbconnect.healthclinix.entity.user.model.UserModel;
import com.jbconnect.healthclinix.security.facade.SecurityFacade;
import com.jbconnect.healthclinix.security.port.GenerateTokenPort;
import com.jbconnect.healthclinix.security.port.LoginPort;

@Component
public class LoginAdapter implements LoginPort<UserRequestDTO, String> {

    private final UserMapper userMapper;

    private final GenerateTokenPort<UserRequestDTO, String> generateTokenPort;

    private final AuthenticationManager authenticationManager;

    public LoginAdapter(UserMapper userMapper, GenerateTokenPort<UserRequestDTO, String> generateTokenPort, AuthenticationManager authenticationManager) {
        this.userMapper = userMapper;
        this.generateTokenPort = generateTokenPort;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String execute(UserRequestDTO userRequestDTO) {
        try{
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userRequestDTO.getUserName(), userRequestDTO.getPasswordUser());
            Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            UserModel userModelAutentication = (UserModel) authentication.getPrincipal();
            UserRequestDTO userRequestDTOAuth = this.userMapper.userModelToUserRequestDTO(userModelAutentication);
            userRequestDTOAuth.setUserName(userModelAutentication.getUsername());

            return this.generateTokenPort.execute(userRequestDTOAuth);
        }catch (Exception e){
            throw new RuntimeException("Error in login {} " + e);
        }
    }
}
