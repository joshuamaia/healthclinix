package com.jbconnect.healthclinix.healthclinix.security.facade

import com.jbconnect.healthclinix.healthclinix.entity.user.repository.UserModelRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class AuthorizationFacadeImpl(val userModelRepository : UserModelRepository ) : UserDetailsService{

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails? {
        return userModelRepository.findByUserName(username)
    }
}