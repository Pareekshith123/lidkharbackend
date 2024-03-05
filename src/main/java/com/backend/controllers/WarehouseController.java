package com.backend.controllers;

import com.backend.Dtos.WarehouseDto;

import com.backend.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;


    @PostMapping("/create")
    public ResponseEntity<WarehouseDto> createWarehouse(@RequestBody WarehouseDto warehouseDto) {

        WarehouseDto createdWarehouse = warehouseService.createWarehouse(warehouseDto);
        return new ResponseEntity<>(createdWarehouse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarehouseDto> updateWarehouse(@PathVariable("id") Long warehouseId, @RequestBody WarehouseDto warehouseDto) {

        WarehouseDto updatedWarehouse = warehouseService.updateWarehouse(warehouseId, warehouseDto);
        return new ResponseEntity<>(updatedWarehouse, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<WarehouseDto>> getAllWarehouses() {

        List<WarehouseDto> warehouses = warehouseService.getAllWarehouses();
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseDto> getWarehouseById(@PathVariable("id") Long warehouseId) {

        WarehouseDto warehouse = warehouseService.getWarehouseById(warehouseId);
        return new ResponseEntity<>(warehouse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWarehouse(@PathVariable("id") Long warehouseId) {

        String message = warehouseService.deleteWarehouse(warehouseId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

