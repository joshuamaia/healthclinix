package com.jbconnect.healthclinix.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbconnect.healthclinix.entity.user.dto.UserRequestDTO;
import com.jbconnect.healthclinix.security.facade.SecurityFacade;

@RestController
@RequestMapping("api/v1/security")
public class SecurityController {

	private final SecurityFacade securityFacade;

	public SecurityController(SecurityFacade securityFacade) {
		this.securityFacade = securityFacade;
	}

	@PostMapping("login")
	public ResponseEntity<String> login(@RequestBody UserRequestDTO userRequestDTO) {
		String token = this.securityFacade.login(userRequestDTO);
		return new ResponseEntity<>(token, HttpStatus.OK);
	}

}
