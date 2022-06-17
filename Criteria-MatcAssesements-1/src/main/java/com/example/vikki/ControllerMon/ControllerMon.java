package com.example.vikki.ControllerMon;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.vikki.MongoModel.EmployeeMongo;
import com.example.vikki.MongoModel.PersonMongo;
import com.example.vikki.ServiceMon.ServiceMon;

@RestController
@RequestMapping(method = RequestMethod.GET, value = "/api/Vignesh")
public class ControllerMon {
	@Autowired
	private ServiceMon mon;
    @PostMapping("/per")
    @PreAuthorize("hasRole('ADMIN')")
	public PersonMongo save(@RequestBody PersonMongo person) {
		return  mon.saves(person);
	}
	@PostMapping("/emp")
	@PreAuthorize("hasRole('ADMIN')")
    public EmployeeMongo saveall(@RequestBody EmployeeMongo  employeeMongo) {
    	return mon.saveAll(employeeMongo);
    }
	@GetMapping("/emp/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Optional<EmployeeMongo> get(@PathVariable Integer  Id) {
		return mon.get(Id);
	}
	
	@GetMapping("/empall")
	@PreAuthorize("hasRole('ADMIN')")
	public List<EmployeeMongo>getall(){
		return mon.getAll();
		
	}
}
