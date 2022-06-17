package com.example.vikki.MongoRepository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.vikki.MongoModel.PersonMongo;
@ Repository
public interface PersonMongoRepository extends MongoRepository<PersonMongo,Integer> {

	Optional<PersonMongo> findByPersonId(Integer personId);

	
	

}
