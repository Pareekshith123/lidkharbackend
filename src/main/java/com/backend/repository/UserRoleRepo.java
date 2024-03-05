package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.backend.Entities.UserRoles;

public interface UserRoleRepo extends JpaRepository<UserRoles, Long> {

	



}
