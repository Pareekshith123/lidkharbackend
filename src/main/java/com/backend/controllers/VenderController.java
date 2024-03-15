package com.backend.controllers;

import com.backend.Dtos.VendersDto;
import com.backend.service.VenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venders")
public class VenderController {

    @Autowired
    private VenderService venderService;

    @PostMapping("/{id}")
    public ResponseEntity<VendersDto> createVender(@PathVariable("id") Long warehouseId ,@RequestBody VendersDto vendersDto) {

        VendersDto createdVender = venderService.createVender(vendersDto,warehouseId);
        return new ResponseEntity<>(createdVender, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendersDto> updateVender(@PathVariable("id") Long venderId, @RequestBody VendersDto vendersDto) {

        VendersDto updatedVender = venderService.updateVender(venderId, vendersDto);
        return new ResponseEntity<>(updatedVender, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<VendersDto>> getAllVenders() {

        List<VendersDto> venders = venderService.getAlVenders();
        return new ResponseEntity<>(venders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendersDto> getVenderById(@PathVariable("id") Long venderId) {
        VendersDto vender = venderService.getVenderById(venderId);
        return new ResponseEntity<>(vender, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVender(@PathVariable("id") Long venderId) {
        String message = venderService.deleteVenderById(venderId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
