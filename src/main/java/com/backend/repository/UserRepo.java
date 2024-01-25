package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Entities.User;




public interface UserRepo extends JpaRepository <User ,Integer>{

}
