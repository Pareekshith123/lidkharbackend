package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.Entities.Images;
@Repository
public interface ImagesRepo extends JpaRepository<Images, Long> {

}
