package com.jbconnect.healthclinix.healthclinix.entity.user.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime


@Entity
@Table(name = "users")
data class UserModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    var userName: String?,

    var passwordUser: String?,

    var email: String?,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_model_id")],
        inverseJoinColumns = [JoinColumn(name = "roles_id")]
    )
    var roles: MutableList<RoleModel>,

    @CreationTimestamp
var createAt: LocalDateTime?,

@UpdateTimestamp
var updateAt: LocalDateTime?
) :  UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority>? {
        val listReturn: MutableList<GrantedAuthority> = ArrayList()
        if (roles.isNotEmpty()) {
            for ((_, name) in roles) {
                listReturn.add(SimpleGrantedAuthority(name))
            }
        }
        return listReturn
    }

    override fun getPassword(): String? {
        return passwordUser
    }

    override fun getUsername(): String? {
        return userName
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}