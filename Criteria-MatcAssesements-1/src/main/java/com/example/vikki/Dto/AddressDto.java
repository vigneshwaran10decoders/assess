package com.example.vikki.Dto;


public class AddressDto {
	 private Integer addId;
	 private String address; 
	 private Integer empId;
	public Integer getAddId() {
		return addId;
	}
	public void setAddId(Integer addId) {
		this.addId = addId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public AddressDto(String address, Integer empId) {
		super();
		this.address = address;
		this.empId = empId;
	}
	 public AddressDto() {
		 
	 }
}
