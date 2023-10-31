package com.jbconnect.healthclinix.healthclinix.security.controller

import com.jbconnect.healthclinix.healthclinix.entity.user.dto.UserRequestDTO
import com.jbconnect.healthclinix.healthclinix.security.facade.SecurityFacade
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1/security")
class SecurityController(val securityFacade : SecurityFacade ) {

    @PostMapping("login")
    fun login(@RequestBody userRequestDTO: UserRequestDTO): ResponseEntity<String> {
        val token: String = this.securityFacade.login(userRequestDTO)
        return ResponseEntity(token, HttpStatus.OK)
    }
}