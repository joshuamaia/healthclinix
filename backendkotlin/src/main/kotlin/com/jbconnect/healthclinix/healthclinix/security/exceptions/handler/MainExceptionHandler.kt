package com.jbconnect.healthclinix.healthclinix.security.exceptions.handler

import com.jbconnect.healthclinix.healthclinix.security.exceptions.ErrorResponse
import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime


@RestControllerAdvice
class MainExceptionHandler {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @ExceptionHandler(Exception::class)
    fun handleException(req: HttpServletRequest, e: Exception): ResponseEntity<*>? {
        e.printStackTrace()
        log.info(e.message)
        return ResponseEntity
            .internalServerError()
            .body<Any>(ErrorResponse(500, req.servletPath, e.message, LocalDateTime.now()))
    }
}