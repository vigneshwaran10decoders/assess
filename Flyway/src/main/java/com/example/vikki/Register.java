package com.example.vikki;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Register {
    @Id
    @GeneratedValue
	private Integer regId;
	private String name;
	private String address;
	private String city;
	
}
