package com.example.vikki.MysqlRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vikki.MysqlModel.Person;

public interface PersonRepository extends JpaRepository<Person,Integer> {

	//Optional<Person> findByPersonId(Integer personId);



}