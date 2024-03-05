package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.Entities.Warehouse;
@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse, Long>{

}
