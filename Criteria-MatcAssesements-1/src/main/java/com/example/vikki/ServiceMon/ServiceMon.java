package com.example.vikki.ServiceMon;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vikki.Dto.EmployeeDto;
import com.example.vikki.MongoModel.EmployeeMongo;
import com.example.vikki.MongoModel.PersonMongo;
import com.example.vikki.MongoRepository.EmployeeMongoRepository;
import com.example.vikki.MongoRepository.PersonMongoRepository;

@Service
public class ServiceMon {

	@Autowired
	private PersonMongoRepository mongoRepository;
	@Autowired
	private EmployeeMongoRepository employeeMongo;
	
	public EmployeeMongo saveAll(EmployeeMongo employeeMon) {
		return employeeMongo.save(employeeMon);
	}
	
	public PersonMongo saves(PersonMongo mongo) {
		return mongoRepository.save(mongo);
	}
	
	
   public Optional<EmployeeMongo> get(Integer Id) {
	   return employeeMongo.findById(Id);
   }
   
    public List<EmployeeMongo> getAll(){
	   
	   return employeeMongo.findAll();			   
   }
}
