package com.backend.Dtos;

public class VendersDto {
	private	Long vendorId;		
	private String vendorName;	
	private String		phoneno;	
	private String	Email;		
	private String	address;	
	private Long description;
	
	public VendersDto() {
		super();
	}
	public VendersDto(Long vendorId, String vendorName, String phoneno, String email, String address, Long description) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.phoneno = phoneno;
		Email = email;
		this.address = address;
		this.description = description;
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
	
}
