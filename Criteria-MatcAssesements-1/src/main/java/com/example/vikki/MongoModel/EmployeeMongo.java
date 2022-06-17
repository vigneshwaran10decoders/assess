package com.example.vikki.MongoModel;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EmployeeMongo {
	private Integer empId;
    private String RoleBased;
    
    private PersonMongo personMongo;
    private AddressMongo addressMongo;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getRoleBased() {
		return RoleBased;
	}
	public void setRoleBased(String roleBased) {
		RoleBased = roleBased;
	}
	public PersonMongo getPersonMongo() {
		return personMongo;
	}
	public void setPersonMongo(PersonMongo personMongo) {
		this.personMongo = personMongo;
	}
	public AddressMongo getAddressMongo() {
		return addressMongo;
	}
	public void setAddressMongo(AddressMongo addressMongo) {
		this.addressMongo = addressMongo;
	}
	
	
	}
 