package com.jbconnect.healthclinix.healthclinix.entity.user.controller

import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserRequestDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserResponseDTO
import com.jbconnect.healthclinix.healthclinix.entity.user.facade.UserCrudFacade
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/users")
class UserController(var facade: UserCrudFacade) {

    @Operation(summary = "Create User")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "User creted with sucessful"),
            ApiResponse(responseCode = "400", description = "Invalid id supplied"),
        ]
    )
    @PostMapping("create")
    fun createUser(@RequestBody userRequestDTO: UserRequestDTO): ResponseEntity<UserResponseDTO?>? {
        val userSaveResponse: UserResponseDTO = this.facade.save(userRequestDTO)
        return ResponseEntity<UserResponseDTO?>(userSaveResponse, HttpStatus.CREATED)
    }

    @Operation(summary = "Search Users")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Found the List of Users"),
            ApiResponse(responseCode = "400", description = "Invalid id supplied"),
        ]
    )

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
    fun findOne(@PathVariable id: Long): ResponseEntity<UserResponseDTO?>? {
        val findOne: UserResponseDTO = this.facade.findOne(id)
        return ResponseEntity(findOne, HttpStatus.OK)
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