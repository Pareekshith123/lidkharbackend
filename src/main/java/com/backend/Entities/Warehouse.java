package com.backend.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long warehouseId;
	private String warehouseName;

	private String description;

	private Long stateId;
	private Long cityId;

	private String PIN;
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	private List<Venders> venders =new ArrayList<>();
 
	public Warehouse() {
		super();
	}

	public Warehouse(Long warehouseId, String warehouseName, String description, Long stateId, Long cityId, String pIN,
			List<Venders> venders) {
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

	public List<Venders> getVenders() {
		return venders;
	}

	public void setVenders(List<Venders> venders) {
		this.venders = venders;
	}

}
