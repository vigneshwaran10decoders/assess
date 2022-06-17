package com.example.vikki;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.vikki.MongoModel.AddressMongo;
import com.example.vikki.MongoModel.EmployeeMongo;
import com.example.vikki.MongoModel.PersonMongo;
import com.example.vikki.MongoRepository.AddressMongoRepository;
import com.example.vikki.MongoRepository.EmployeeMongoRepository;
import com.example.vikki.MongoRepository.PersonMongoRepository;
import com.example.vikki.MysqlRepository.AddressRepository;
import com.example.vikki.MysqlRepository.EmployeeRepository;
import com.example.vikki.MysqlRepository.PersonRepository;

@SpringBootTest
class CriteriaMatcAssesements1ApplicationTests {
	@Autowired
	private PersonRepository personRepository;
	@Mock
	private  PersonMongoRepository  mongoRepository;
	@Mock
	private AddressMongoRepository addressMongoRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Mock
	private EmployeeMongoRepository employeeMongoRepository;

	//PostMapping Testing.....

	@Test
	void test() {
		PersonMongo dao=new  PersonMongo();
		dao.setName("vikkywaran");
		dao.setPhno(98765987);
		dao.setPersonId(1);
		mongoRepository.save(dao);
		// assertNotNull(personRepository.findById(1).get());
	}
	@Test
	void test1() {
		EmployeeMongo da=new EmployeeMongo();
		da.setEmpId(1);
		da.setRoleBased("backend");
		employeeMongoRepository.save(da);


	} 
	@Test
	void test2() {
		AddressMongo d=new AddressMongo();
		d.setAddId(1);
		d.setAddress("che");
		addressMongoRepository.save(d);


	}

	//GetMapping Testing......
	@Test
	void test4() {
		List<EmployeeMongo> list=employeeMongoRepository.findAll();
		assertThat(list).size().isPositive();

	}

}







// assertNotNull(employeeRepository.findById(1).get());








