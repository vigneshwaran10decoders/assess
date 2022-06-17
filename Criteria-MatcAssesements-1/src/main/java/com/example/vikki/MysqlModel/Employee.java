package com.example.vikki.MysqlModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	@Id
   private Integer empId;
	
   private String RoleBased;
  
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "personId", nullable = true)
   private Person person;
   
   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn( name="empId",referencedColumnName="empId")
   List<Address>list=new ArrayList<>();

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

public Person getPerson() {
	return person;
}

public void setPerson(Person person) {
	this.person = person;
}

public List<Address> getList() {
	return list;
}

public void setList(List<Address> list) {
	this.list = list;
}

public Employee(String roleBased, Person person, List<Address> list) {
	super();
	RoleBased = roleBased;
	this.person = person;
	this.list = list;
}
   public Employee() {
	   
   }
   
   
}