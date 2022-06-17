package com.example.vikki.Security;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vikki.Dto.EmployeeDto;
import com.example.vikki.Exception.AlreadyExistException;
import com.example.vikki.Exception.EmptyInputException;

import com.example.vikki.Model.UserDao;
import com.example.vikki.MongoModel.AddressMongo;
import com.example.vikki.MongoModel.EmployeeMongo;
import com.example.vikki.MongoModel.PersonMongo;
import com.example.vikki.MongoRepository.AddressMongoRepository;
import com.example.vikki.MongoRepository.EmployeeMongoRepository;
import com.example.vikki.MongoRepository.PersonMongoRepository;
import com.example.vikki.MysqlModel.Address;
import com.example.vikki.MysqlModel.Employee;
import com.example.vikki.MysqlModel.Person;
import com.example.vikki.MysqlRepository.AddressRepository;
import com.example.vikki.MysqlRepository.EmployeeRepository;
import com.example.vikki.MysqlRepository.PersonRepository;
import com.example.vikki.MysqlRepository.UserDaoRepository;
import com.example.vikki.Repository.UserRepository;



@Service
public class ServiceMysqlLayer implements UserDetailsService {
  @Autowired
  UserRepository userRepository;
  
  @Autowired
	private UserDaoRepository userDao;
	  
		@Autowired
		private PersonRepository  personRepository;

	@Autowired   
	private  PersonMongoRepository personMongoRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository ;
	
     @Autowired
	private EmployeeMongoRepository employeeMongoRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressMongoRepository addressMongoRepository;
	
	public Page<Employee> findAll(Pageable pageable) {
		//Employee employee=new Employee();
		Page<Employee>list= employeeRepository.findAll(pageable);
		if(list.isEmpty())
			throw new NoSuchElementException();
	return list;
	}

	public Person save(Person per) {
//		if(per.getName().isEmpty()|| per.getName().length()==0) {
//			throw new EmptyInputException();
//		
	    // Optional<Person>person =personRepository.findById(per.getPersonId());
//	     if(person.isPresent()) {
//	     throw new AlreadyExistException();
//	     }else {
//	    	 
//	     
		return personRepository.save(per);
	     }
		
	//}

	public PersonMongo saves(PersonMongo per) {
//		Optional<PersonMongo>person =personMongoRepository.findById(per.getPersonId());
//	     if(person.isPresent()) {
//	     throw new AlreadyExistException();
//	     }else {
//		
		return personMongoRepository.save(per);
	     }
	//}
	public UserDao save(UserDao user)
	{
		if(user.getUsername().isEmpty()|| user.getEmail().length()==0) {
			throw new EmptyInputException();
		}
		return userDao.save(user);
	}
	public Employee getId (Integer Id) {
		return employeeRepository.findById(Id).orElseThrow();
	}
	public Employee save(EmployeeDto emp) {
		Optional<Person> person=personRepository.findById(emp.getPersonId());
	     if(person.isPresent()) {
			Person per=person.get();
			Employee employee=new Employee();
			employee.setPerson(per);
			BeanUtils.copyProperties(emp,employee);
			employeeRepository.save(employee);
		    Address address =new Address();
			address.setAddId(emp.getAddId());
			address.setAddress(emp.getAddress());
			address.setEmpId(emp.getEmpId());
			BeanUtils.copyProperties(emp,address);
			addressRepository.save(address);
			 
			if(emp.getAddress().isEmpty()|| emp.getRoleBased().length()==0) {
				throw new EmptyInputException();
			}
			//BeanUtils.copyProperties(address, employee);
			return employee;
			//return employeeRepository.save(employee);
		}else {
			return null;
		}
	}
	public EmployeeMongo saveall(EmployeeDto emp) {
		Optional<PersonMongo> person=personMongoRepository.findByPersonId(emp.getPersonId());
	     if(person.isPresent()) {
			PersonMongo per=person.get();
			EmployeeMongo employee=new EmployeeMongo();
			employee.setPersonMongo(per);
			BeanUtils.copyProperties(emp,employee);
			
			 AddressMongo address =new AddressMongo();
				address.setAddId(emp.getAddId());
				address.setAddress(emp.getAddress());
				address.setEmpId(emp.getEmpId());
				employee.setAddressMongo(address);
				BeanUtils.copyProperties(emp,address);
				addressMongoRepository.save(address);
	            employeeMongoRepository.save(employee);
		    
			
			
			if(address.getAddress().isEmpty()|| emp.getRoleBased().length()==0) {
				throw new EmptyInputException();
			}
			//BeanUtils.copyProperties(address, employee);
			return employee;
			//return employeeRepository.save(employee);
		}else {
			return null;
		}
	}
	 @Override
	  @Transactional
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    UserDao user = userRepository.findByUsername(username)
	        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

	    return UserDetailsImpl.build(user);
	  }


}

  
  


