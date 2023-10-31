package com.jbconnect.healthclinix.entity.user.repository;

import com.jbconnect.healthclinix.entity.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserModelRepository extends JpaRepository<UserModel, Long>, JpaSpecificationExecutor<UserModel> {
    UserDetails findByUserName(String userName);
}
