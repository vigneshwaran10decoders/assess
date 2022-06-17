package com.example.vikki.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {

     @Id	
     private Integer id;
	 private String name;
	 private float mark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
	public Student(String name, float mark) {
		super();
		this.name = name;
		this.mark = mark;
	}
	 public Student() {
		 
	 }
}
