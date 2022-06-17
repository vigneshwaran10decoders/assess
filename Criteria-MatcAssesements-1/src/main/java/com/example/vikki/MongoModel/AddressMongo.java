package com.example.vikki.MongoModel;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AddressMongo {
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

	public AddressMongo() {
		 
	 }
}


