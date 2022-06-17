package com.example.vikki.MysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vikki.MysqlModel.Address;

public interface AddressRepository  extends JpaRepository<Address,Integer>{

	//Address save(Optional<Employee> employee);

}