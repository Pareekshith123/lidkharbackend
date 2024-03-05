package com.backend.service.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Dtos.WarehouseDto;
import com.backend.Entities.Warehouse;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.repository.VenderRepo;
import com.backend.repository.WarehouseRepo;
import com.backend.service.WarehouseService;
@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired 
    private WarehouseRepo warehouseRepo;

  @Autowired
  private VenderRepo venderRepo;

    @Override
    public WarehouseDto createWarehouse(WarehouseDto warehouseDto) {

        Warehouse warehouse = dtoToWarehouse(warehouseDto);
       this.warehouseRepo.save(warehouse);
      
        return WarehouseToDto(warehouse);
    }

    @Override
    public WarehouseDto updateWarehouse(Long warehouseId, WarehouseDto warehouseDto) {

        // Add logic to fetch the warehouse entity from the database by warehouseId
        // Add logic to update the warehouse entity with data from warehouseDto
    Warehouse existingWarehouse = warehouseRepo.findById(warehouseId)
            .orElseThrow(() -> new ResourceNotFoundException("warehouse", "warehouseId", warehouseId));
        existingWarehouse.setWarehouseName(warehouseDto.getWarehouseName());
        existingWarehouse.setDescription(warehouseDto.getDescription());
        existingWarehouse.setStateId(warehouseDto.getStateId());
        existingWarehouse.setCityId(warehouseDto.getCityId());
        existingWarehouse.setPIN(warehouseDto.getPIN());
        
      
 Warehouse save = this.warehouseRepo.save(existingWarehouse);
       WarehouseDto warehouseToDto = this.WarehouseToDto(save);
        return warehouseToDto;
    }

    @Override
    public List<WarehouseDto> getAllWarehouses() {

        List<Warehouse> warehouseList = this.warehouseRepo.findAll();
        List<WarehouseDto> warehouseDtoList = warehouseList.stream().map(this:: WarehouseToDto).collect(Collectors.toList());
        return warehouseDtoList; 
    }

    @Override
    public WarehouseDto getWarehouseById(Long warehouseId) {

    	  Warehouse existingWarehouse = warehouseRepo.findById(warehouseId)
    	            .orElseThrow(() -> new ResourceNotFoundException("warehouse", "warehouseId", warehouseId));
        return this.WarehouseToDto(existingWarehouse); 
    }

    @Override
    public String deleteWarehouse(Long warehouseId) {
    	  Warehouse existingWarehouse = warehouseRepo.findById(warehouseId)
    	            .orElseThrow(() -> new ResourceNotFoundException("warehouse", "warehouseId", warehouseId));
      this.warehouseRepo.delete(existingWarehouse);

        return "The warehouse is deleted sucessfully"; }

    public WarehouseDto WarehouseToDto(Warehouse warehouse) {
        return this.modelMapper.map(warehouse, WarehouseDto.class);
    }

    public Warehouse dtoToWarehouse(WarehouseDto warehouseDto){
        return this.modelMapper.map(warehouseDto, Warehouse.class);
    }
}
