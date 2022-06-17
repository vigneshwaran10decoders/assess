//package com.example.vikki.ServiceMysql;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.vikki.Dto.EmployeeDto;
//import com.example.vikki.Model.UserDao;
//import com.example.vikki.Model.UserDto;
//import com.example.vikki.MongoModel.AddressMongo;
//import com.example.vikki.MongoModel.EmployeeMongo;
//import com.example.vikki.MongoModel.PersonMongo;
//import com.example.vikki.MongoRepository.AddressMongoRepository;
//import com.example.vikki.MongoRepository.EmployeeMongoRepository;
//import com.example.vikki.MongoRepository.PersonMongoRepository;
//import com.example.vikki.MysqlModel.Address;
//import com.example.vikki.MysqlModel.Employee;
//import com.example.vikki.MysqlModel.Person;
//import com.example.vikki.MysqlRepository.AddressRepository;
//import com.example.vikki.MysqlRepository.EmployeeRepository;
//import com.example.vikki.MysqlRepository.PersonRepository;
//import com.example.vikki.MysqlRepository.UserDaoRepository;
//import com.example.vikki.Security.UserDetailsImpl;
//
//@Service
//public class ServiceMysqlLayer implements UserDetailsService {
//	
//     
//
//	@Autowired
//	private UserDaoRepository userDao;
//	  
//		@Autowired
//		private PersonRepository  personRepository;
//
//	@Autowired   
//	private  PersonMongoRepository personMongoRepository;
//	@Autowired
//	private EmployeeRepository employeeRepository ;
//
//	private EmployeeMongoRepository employeeMongoRepository;
//
//	@Autowired
//	private AddressRepository addressRepository;
//	@Autowired
//	private AddressMongoRepository addressMongoRepository;
//	public List<Employee> getAll(Employee emp) {
//		return employeeRepository.findAll();
//	}
//
//	public Person save(Person per) {
//		return personRepository.save(per);
//	}
//
//	public PersonMongo saves(PersonMongo per) {
//		return personMongoRepository.save(per);
//	}
//	public UserDao save(UserDao user)
//	{
//		return userDao.save(user);
//	}
//	public Employee save(EmployeeDto emp) {
//		Optional<Person> person=personRepository.findById(emp.getPersonId());
//		if(person.isPresent()) {
//			Person per=person.get();
//			Employee employee=new Employee();
//			employee.setPerson(per);
//			BeanUtils.copyProperties(emp,employee);
//	        Employee ep= employeeRepository.save(employee);
//		    Address address =new Address();
//			address.setAddId(emp.getAddId());
//			address.setAddress(emp.getAddress());
//			address.setEmpId(emp.getEmpId());
//			BeanUtils.copyProperties(emp,address);
//			addressRepository.save(address);
//			//BeanUtils.copyProperties(address, employee);
//			return ep;
//			//return employeeRepository.save(employee);
//		}else {
//			return null;
//		}
//	}
//	public EmployeeMongo saveall(EmployeeDto emp) {
//		Optional<PersonMongo> person=personMongoRepository.findById(emp.getPersonId());
//		if(person.isPresent()) {
//			PersonMongo per=person.get();
//			EmployeeMongo employeemongo=new EmployeeMongo();
//			employeemongo.setPersonMongo(per);
//			BeanUtils.copyProperties(emp,employeemongo);
//			//EmployeeMongo ep1= employeeMongoRepository.save(employeemongo);
//			AddressMongo addressmongo =new AddressMongo();
//			addressmongo.setAddId(emp.getAddId());
//            addressmongo.setAddress(emp.getAddress());
//			addressmongo.setEmpId(emp.getEmpId());
//			BeanUtils.copyProperties(emp,addressmongo);
//			addressMongoRepository.save(addressmongo);
//			//BeanUtils.copyProperties(ep1, addressmongo);
//			
//			return employeeMongoRepository.save(employeemongo);
//		}else {
//			return null;
//		}
//
//	}
////	@Override
////	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		UserDao user = userDao.findByUsername(username);
////		if (user == null) {
////			throw new UsernameNotFoundException("User not found with username: " + username);
////		}
////		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
////				new ArrayList<>());
////	}
////	public UserDao save(UserDto user) {
////		UserDao newUser =new UserDao();
////		newUser.setUsername(user.getUsername());
////		newUser.setPassword(user.getPassword());
////		return userDao.save(newUser);
////	}
//	 @Override
//	  @Transactional
//	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	    UserDao user = userRepository.findByUsername(username)
//	        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
//
//	    return UserDetailsImpl.build(user);
//	  }
//
//
//}
