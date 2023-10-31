package com.jbconnect.healthclinix.healthclinix.entity.user.repository

import com.jbconnect.healthclinix.healthclinix.entity.user.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.security.core.userdetails.UserDetails




interface UserModelRepository: JpaRepository<UserModel, Long>, JpaSpecificationExecutor<UserModel> {

    fun findByUserName(userName: String): UserDetails?

}