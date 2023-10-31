package com.jbconnect.healthclinix.healthclinix.entity.user.controller

import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserRequestDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserResponseDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.facade.UserCrudFacade
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1/users")
class UserController(var facade: UserCrudFacade) {
    @PostMapping("create")
    fun createUser(@RequestBody userRequestDTO: UserRequestDTO): ResponseEntity<UserResponseDTO?>? {
        val userSaveResponse: UserResponseDTO = this.facade.save(userRequestDTO)
        return ResponseEntity<UserResponseDTO?>(userSaveResponse, HttpStatus.CREATED)
    }

    @PostMapping("get-by-filters")
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
    fun getByFilters(
        pageable: Pageable,
        @RequestBody userRequestDTO: UserRequestDTO
    ): ResponseEntity<Page<UserResponseDTO>> {
        val getAllByPage: Page<UserResponseDTO> = this.facade.getByFilters(pageable, userRequestDTO)
        return ResponseEntity<Page<UserResponseDTO>>(getAllByPage, HttpStatus.OK)
    }
}