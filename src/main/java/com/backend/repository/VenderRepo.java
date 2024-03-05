package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.Entities.Venders;
@Repository
public interface VenderRepo extends JpaRepository<Venders, Long> {

}
