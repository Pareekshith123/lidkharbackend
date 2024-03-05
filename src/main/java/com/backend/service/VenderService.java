package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.Dtos.VendersDto;

@Service
public interface VenderService {
public VendersDto createVender(VendersDto vendersDto,Long warehouseId);
public VendersDto updateVender(Long venderId ,VendersDto vendersDto);
public List<VendersDto> getAlVenders();
public VendersDto getVenderById(Long venderId);
public String deleteVenderById(Long venderId);
}
