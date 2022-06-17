package com.example.vikki.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.vikki.Model.Filter;
import com.example.vikki.Security.ServiceMysqlLayer;




@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
      @Autowired
	  private ServiceMysqlLayer myuserDetailsService;
      
      @Autowired
  	  private Filter filter;
      
   
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 auth.userDetailsService(myuserDetailsService);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.csrf().disable()
		.authorizeRequests().antMatchers("/api/Vignesh").permitAll()
		.antMatchers("/api/Vignesh/auth").permitAll()
		.antMatchers("/api/Vignesh/signup").permitAll()
		.antMatchers("/api/Vignesh/employee").hasRole("ADMIN")
		.antMatchers("/api/Vignesh/person").hasRole("ADMIN")
		.antMatchers("/api/Vignesh/getperson").hasRole("ADMIN")
		.antMatchers("/api/Vignesh/per").hasRole("ADMIN")
		.antMatchers("/api/Vignesh/emp").hasRole("ADMIN")
		.antMatchers("/api/Vignesh/emp/{id}").hasAnyRole("ADMIN","USER")
		.antMatchers("/api/Vignesh/empall").hasRole("ADMIN")
		.antMatchers("/api/Vignesh/getemployee").hasAnyRole("ADMIN","USER")
		
		

		.anyRequest().permitAll().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}

    @Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {

		return super.authenticationManager();
	}
}
