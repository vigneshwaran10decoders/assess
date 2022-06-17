package com.example.vikki.Dto;

public class PersonDto {
	private Integer personId;
	private String name;
	private long phno;
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public PersonDto(String name, long phno) {
		super();
		this.name = name;
		this.phno = phno;
	}
	public PersonDto() {
		
	}
	
}

