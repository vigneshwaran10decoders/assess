package com.example.vikki.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vikki.Model.Student;
import com.example.vikki.Service.ServiceLayer;
@RestController
public class ControllerLayer {

	@Autowired
	private ServiceLayer serviceControl;
	
	
	@PostMapping("/student")
	public Student add(@RequestBody Student student) {
		return serviceControl.add(student);
	}
}
