package com.backend.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.backend.Dtos.WarehouseDto;

@Service
public interface WarehouseService {
   public WarehouseDto createWarehouse(WarehouseDto warehouseDto);
   public WarehouseDto updateWarehouse( Long warehouseId, WarehouseDto warehouseDto);
    public List<WarehouseDto> getAllWarehouses();
    public WarehouseDto  getWarehouseById(Long warehouseId);	
    public String deleteWarehouse(Long warehouseId);
}
