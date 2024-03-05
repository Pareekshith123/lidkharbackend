package com.backend.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Dtos.VendersDto;
import com.backend.Entities.Venders;
import com.backend.Entities.Warehouse;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.repository.VenderRepo;
import com.backend.repository.WarehouseRepo;
import com.backend.service.VenderService;
@Service
public class VenderServiceImpl implements VenderService {
	@Autowired
	private ModelMapper modelMapper;

	 @Autowired
	    private VenderRepo venderRepo;


	 @Autowired
	 private WarehouseRepo warehouseRepo;
	@Override
	public VendersDto createVender(VendersDto vendersDto ,Long warehouseId ) {


           Warehouse warehouse = this.warehouseRepo.findById(warehouseId)
           .orElseThrow(()->new ResourceNotFoundException("warehouseId", "warehouseId", warehouseId));
           Venders vender = this.DtoToVenders(vendersDto);
           vender.setVendorName(vendersDto.getVendorName());
   		vender.setPhoneno(vendersDto.getPhoneno());
   		vender.setEmail( vendersDto.getEmail());
   		vender.setAddress(vendersDto.getAddress());
   		vender.setDescription(vendersDto.getDescription());
   		vender.setWarehouse(warehouse);
   		 Venders save2 = this.venderRepo.save(vender);
           
          
       
          
            
		return this.VendersTODto(save2);
	}

	@Override
	public VendersDto updateVender(Long venderId, VendersDto vendersDto) {



		Venders vender = this.venderRepo.findById(venderId)
		.orElseThrow(()->new ResourceNotFoundException("venderId", "venderId", venderId));
		vender.setVendorName(vendersDto.getVendorName());
		vender.setPhoneno(vendersDto.getPhoneno());
		vender.setEmail( vendersDto.getEmail());
		vender.setAddress(vendersDto.getAddress());
		vender.setDescription(vendersDto.getDescription());
		 Venders save2 = this.venderRepo.save(vender);
			return this.VendersTODto(save2);
	}

	@Override
	public List<VendersDto> getAlVenders() {
	List<Venders> findAll = this.venderRepo.findAll();
	List<VendersDto> venderList = findAll.stream().map(this::VendersTODto).collect(Collectors.toList());
		return venderList;
	}

	@Override
	public VendersDto getVenderById(Long venderId) {
		Venders vender = this.venderRepo.findById(venderId)
				.orElseThrow(()->new ResourceNotFoundException("venderId", "venderId", venderId));
				return this.VendersTODto(vender);
	}

	@Override
	public String deleteVenderById(Long venderId) {

		Venders vender = this.venderRepo.findById(venderId)
				.orElseThrow(()->new ResourceNotFoundException("venderId", "venderId", venderId));
		this.venderRepo.delete(vender);
				return "The vender is deleted successfully";
	}

	public VendersDto VendersTODto(Venders venders) {

		return this.modelMapper.map(venders, VendersDto.class);
	}
	public Venders DtoToVenders(VendersDto vendersDto) {

		return this.modelMapper.map(vendersDto, Venders.class);
	}

}
