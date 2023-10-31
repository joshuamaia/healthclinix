package com.jbconnect.healthclinix.entity.user.controller;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbconnect.healthclinix.entity.user.dto.UserRequestDTO;
import com.jbconnect.healthclinix.entity.user.dto.UserResponseDTO;
import com.jbconnect.healthclinix.entity.user.facade.UserCrudFacade;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	private final UserCrudFacade userCrudFacade;

	public UserController(UserCrudFacade userCrudFacade) {
		this.userCrudFacade = userCrudFacade;
	}

	@PostMapping("create")
	public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
		UserResponseDTO userSaveResponse = this.userCrudFacade.save(userRequestDTO);
		return new ResponseEntity<>(userSaveResponse, HttpStatus.CREATED);
	}

	@PostMapping("get-by-filters")
	@PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
	public ResponseEntity<Page<UserResponseDTO>> getByFilters(Pageable pageable,
			@RequestBody UserRequestDTO userRequestDTO) {
		Page<UserResponseDTO> getAllByPage = this.userCrudFacade.getByFilters(pageable, userRequestDTO);
		return new ResponseEntity<>(getAllByPage, HttpStatus.OK);
	}

}
