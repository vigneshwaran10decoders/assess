package com.example.vikki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CriteriaMatcAssesements1Application {

	public static void main(String[] args) {
		SpringApplication.run(CriteriaMatcAssesements1Application.class, args);
	}
	
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
@Bean
public RestTemplate restTemplate(RestTemplateBuilder builder) {
	return builder.build();
}

}
