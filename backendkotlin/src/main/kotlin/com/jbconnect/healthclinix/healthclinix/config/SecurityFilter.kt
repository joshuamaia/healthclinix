package com.jbconnect.healthclinix.healthclinix.config

import com.jbconnect.healthclinix.healthclinix.entity.user.repository.UserModelRepository
import com.jbconnect.healthclinix.healthclinix.security.port.ValidateTokenPort
import jakarta.servlet.FilterChain

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class SecurityFilter(val validateTokenPort : ValidateTokenPort<String, String>, val userModelRepository : UserModelRepository ) :
    OncePerRequestFilter() {
     override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val tokenRecovered = recoverToken(request)
        if (tokenRecovered != null) {
            val userName = validateTokenPort.execute(tokenRecovered)
            val user: UserDetails? = userModelRepository.findByUserName(userName)
            val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(user, null, user?.authorities)
            SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
        }
        filterChain.doFilter(request, response)
    }

    private fun recoverToken(httpServletRequest: HttpServletRequest): String? {
        val authorizationHeader = httpServletRequest.getHeader("Authorization")
        return authorizationHeader?.replace("Bearer ", "")
    }
}