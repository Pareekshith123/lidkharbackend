package com.backend.Dtos;

import java.util.ArrayList;
import java.util.List;

public class WarehouseDto {

	private Long warehouseId;
	private String warehouseName;

	private String description;

	private Long stateId;
	private Long cityId;

	private String PIN;
	private List<VendersDto> venders = new ArrayList<>();

	public WarehouseDto() {
		super();
	}
	

	public WarehouseDto(Long warehouseId, String warehouseName, String description, Long stateId, Long cityId,
			String pIN, List<VendersDto> venders) {
		super();
		this.warehouseId = warehouseId;
		this.warehouseName = warehouseName;
		this.description = description;
		this.stateId = stateId;
		this.cityId = cityId;
		PIN = pIN;
		this.venders = venders;
	}


	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pIN) {
		PIN = pIN;
	}

	public List<VendersDto> getVenders() {
		return venders;
	}

	public void setVenders(List<VendersDto> venders) {
		this.venders = venders;
	}

}
