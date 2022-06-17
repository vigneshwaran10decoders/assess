package com.example.vikki.MongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.vikki.MongoModel.EmployeeMongo;
@Repository
public interface EmployeeMongoRepository extends MongoRepository<EmployeeMongo,Integer> {

	//EmployeeMongo save(AddressMongo addressmongo);

}
