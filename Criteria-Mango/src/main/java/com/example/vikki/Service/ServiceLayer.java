package com.example.vikki.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vikki.Model.Student;
import com.example.vikki.Repository.StudentRepository;


@Service
public class ServiceLayer {
     
	@Autowired
	private  StudentRepository studentService;
	public Student add(Student stud) {
		return studentService.save(stud);
	}
	
}
