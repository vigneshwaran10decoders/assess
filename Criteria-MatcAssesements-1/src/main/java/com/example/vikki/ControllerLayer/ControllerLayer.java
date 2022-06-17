package com.example.vikki.ControllerLayer;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.vikki.Dto.EmployeeDto;
import com.example.vikki.Dto.PersonDto;
import com.example.vikki.Model.Erole;
import com.example.vikki.Model.Role;
import com.example.vikki.Model.UserDao;
import com.example.vikki.MongoModel.EmployeeMongo;
import com.example.vikki.MongoModel.PersonMongo;
import com.example.vikki.MysqlModel.Employee;
import com.example.vikki.MysqlModel.Person;
import com.example.vikki.PayLoad.JwtResponse;
import com.example.vikki.PayLoad.LoginRequest;
import com.example.vikki.PayLoad.MessageResponse;
import com.example.vikki.PayLoad.SignupRequest;
import com.example.vikki.Repository.RoleRepository;
import com.example.vikki.Repository.UserRepository;
import com.example.vikki.Response.ResponseModel;
import com.example.vikki.Response.ResponseModel1;
import com.example.vikki.Security.ServiceMysqlLayer;
import com.example.vikki.Security.UserDetailsImpl;
import com.example.vikki.Util.JwtUtil;

@RestController
@RequestMapping(method = RequestMethod.GET, value = "/api/Vignesh")
public class ControllerLayer {

  Logger logger =LoggerFactory.getLogger(ControllerLayer.class);
	@Autowired
	private PasswordEncoder bCryptEncoder;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private ServiceMysqlLayer serviceMysqlLayer;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@GetMapping("/getperson")
	@PreAuthorize("hasRole('ADMIN')")
	public  ResponseEntity<?> get(Pageable emp ){
		
		ResponseModel1 responseModel=new ResponseModel1(HttpStatus.OK, 
				serviceMysqlLayer.findAll(emp), "Success", "No Error", new Date());
		return new ResponseEntity<ResponseModel1>(responseModel,HttpStatus.OK);
	}
   
	
	


	 
	@PostMapping("/person")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> save(@RequestBody PersonDto person) {
//		logger.info("[getMessage] info message");
//		System.out.println("person id not found");
		Person per=new Person();
		System.out.println("person is ready");
	    
		System.out.println(System.currentTimeMillis());
		BeanUtils.copyProperties(person,per);
		System.out.println(System.currentTimeMillis());
				
		serviceMysqlLayer.save(per);
		//ResponseEntity<String>responseEntity=restTemplate.getForEntity(null, null)

		PersonMongo personmongo =new PersonMongo();
		System.out.println(System.currentTimeMillis());
		serviceMysqlLayer.saves(personmongo);
		BeanUtils.copyProperties(person,personmongo);
		System.out.println(System.currentTimeMillis());
		//return person;
		ResponseModel responseModel=new ResponseModel(HttpStatus.OK,serviceMysqlLayer.save(per)
				,serviceMysqlLayer.saves(personmongo),"Success","No Error",new Date());
		return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.OK);
	}
	@PostMapping("/employee")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> save(@RequestBody EmployeeDto employee) {
		Employee emp=new Employee();
		BeanUtils.copyProperties(employee, emp);
		serviceMysqlLayer.save(employee);

		EmployeeMongo employeemongo =new EmployeeMongo();
	    BeanUtils.copyProperties(employee, employeemongo);
	    serviceMysqlLayer.saveall(employee);
	    
		ResponseModel responseModel=new ResponseModel(HttpStatus.OK,serviceMysqlLayer.save(employee)
				,serviceMysqlLayer.saveall(employee),"Success","No Error",new Date());
		return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.OK);
		
		
		

//		return employee;

	}
	
	@GetMapping("/getemployee/{Id}")
	 @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?>get(@PathVariable Integer Id) {
		ResponseModel1 responseModel=new ResponseModel1(HttpStatus.OK,serviceMysqlLayer.getId(Id)
				,"Success","No Error",new Date());
		return new ResponseEntity<ResponseModel1>(responseModel,HttpStatus.OK);
		
		//return serviceMysqlLayer.getId(Id);
	}


	@PostMapping("/auth")
	
	public ResponseEntity<?>createAuthenticationToken(@RequestBody LoginRequest auth) throws Exception{
		Authentication authentication = authenticationmanager.authenticate(
				new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		System.out.println(authentication);
		String jwt = jwtUtil.generateToken(authentication);
		System.out.println(jwtUtil);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(new JwtResponse(jwt, 
				userDetails.getId(), 
				userDetails.getUsername(), 
				userDetails.getEmail(), 
				roles));
	}
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
	
		UserDao user = new UserDao(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 bCryptEncoder.encode(signUpRequest.getPassword()));
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(Erole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(Erole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				case "mod":
					Role modRole = roleRepository.findByName(Erole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);
					break;
				default:
					Role userRole = roleRepository.findByName(Erole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}


