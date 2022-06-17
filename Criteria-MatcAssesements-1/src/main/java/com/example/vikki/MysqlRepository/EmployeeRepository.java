package com.example.vikki.MysqlRepository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.vikki.MysqlModel.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {

//	Employee save(Address address);
	
}