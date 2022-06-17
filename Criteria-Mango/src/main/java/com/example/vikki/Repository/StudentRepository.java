package com.example.vikki.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.vikki.Model.Student;

public interface StudentRepository extends MongoRepository<Student,Integer> {

}
