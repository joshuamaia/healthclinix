package com.jbconnect.healthclinix.healthclinix.entity.user.dto


import java.time.LocalDateTime;
data class UserRequestDTO (
    var id: Long?,

    var userName: String?,

    var passwordUser: String?,

    var email: String?,

    var roles: MutableList<RoleDTO>?,

    var createAt:LocalDateTime?,

    var updateAt: LocalDateTime?
)
