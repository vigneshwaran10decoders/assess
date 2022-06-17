package com.example.vikki.MongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.vikki.MongoModel.AddressMongo;
@Repository 
public interface AddressMongoRepository extends MongoRepository<AddressMongo,Integer>{

	//AddressMongo save(Address address);

}