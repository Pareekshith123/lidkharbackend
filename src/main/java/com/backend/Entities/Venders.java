package com.backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="venders")
public class Venders {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private	Long vendorId;		
private String vendorName;	
private String		phoneno;	
private String	Email;		
private String	address;	
private Long description;
@ManyToOne
@JoinColumn(name="warehouse_id")
private Warehouse warehouse;
public Venders() {

	super();
}

public Venders(Long vendorId, String vendorName, String phoneno, String email, String address, Long description,
		Warehouse warehouse) {
	super();
	this.vendorId = vendorId;
	this.vendorName = vendorName;
	this.phoneno = phoneno;
	Email = email;
	this.address = address;
	this.description = description;
	this.warehouse = warehouse;
}

public Long getVendorId() {
	return vendorId;
}
public void setVendorId(Long vendorId) {
	this.vendorId = vendorId;
}
public String getVendorName() {
	return vendorName;
}
public void setVendorName(String vendorName) {
	this.vendorName = vendorName;
}
public String getPhoneno() {
	return phoneno;
}
public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Long getDescription() {
	return description;
}
public void setDescription(Long description) {
	this.description = description;
}
public Warehouse getWarehouse() {
	return warehouse;
}
public void setWarehouse(Warehouse warehouse) {
	this.warehouse = warehouse;
}


}
