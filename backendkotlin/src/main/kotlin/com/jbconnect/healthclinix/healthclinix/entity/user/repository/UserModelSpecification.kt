package com.jbconnect.healthclinix.healthclinix.entity.user.repository

import com.jbconnect.healthclinix.healthclinix.entity.user.model.UserModel
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification


object UserModelSpecification {

    fun getByFilters(userModel: UserModel): Specification<UserModel?> {
        var specificationId: Specification<UserModel?>? = null
        var specificationUserName: Specification<UserModel?>? = null
        var specificationEmail: Specification<UserModel?>? = null

        if (userModel.id != null) {
            specificationId = getById(userModel.id)
        }
        if (userModel.userName != null) {
            specificationUserName = getByUserNameLike(userModel.userName)
        }
        if (userModel.email != null) {
            specificationEmail = getByEmailLike(userModel.email)
        }

        return Specification.where(specificationId)
            .and(specificationUserName)
            .and(specificationEmail)
    }

    private fun getById(id: Long?): Specification<UserModel?> {
        return Specification { root: Root<UserModel?>, _: CriteriaQuery<*>?, criteriaBuilder: CriteriaBuilder ->
            criteriaBuilder.equal(
                root.get<Any>("id"),
                id
            )
        }
    }

    private fun getByUserNameLike(userName: String?): Specification<UserModel?> {
        return Specification { root: Root<UserModel?>, _: CriteriaQuery<*>?, criteriaBuilder: CriteriaBuilder ->
            criteriaBuilder.like(
                root["userName"],
                "%" + userName?.trim { it <= ' ' } + "%")
        }
    }

    private fun getByEmailLike(email: String?): Specification<UserModel?> {
        return Specification { root: Root<UserModel?>, _: CriteriaQuery<*>?, criteriaBuilder: CriteriaBuilder ->
            criteriaBuilder.like(
                root["email"],
                "%" + email?.trim { it <= ' ' } + "%")
        }
    }

}